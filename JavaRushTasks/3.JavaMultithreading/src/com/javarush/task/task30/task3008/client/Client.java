package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() throws IOException {
        ConsoleHelper.writeMessage("Please enter server address to start...");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {
        ConsoleHelper.writeMessage("Please enter server port to start...");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()  throws IOException {
        ConsoleHelper.writeMessage("Please enter your name or nickname...");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread()  {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("We have a several problems... connection is lost.");
            clientConnected = false;
        }
    }
    public void run() throws IOException {
        {
            SocketThread socketThread = getSocketThread();
            socketThread.setDaemon(true);
            socketThread.start();
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Ошибка потока...");
                System.exit(1);
            }
            if (clientConnected) {
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’");
                while (clientConnected) {
                    String message = ConsoleHelper.readString();
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (shouldSendTextFromConsole()) {
                            sendTextMessage(message);
                        }
                    }
                }
            } else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        try {
            client.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public class SocketThread extends Thread{
            protected void processIncomingMessage(String message) {
                ConsoleHelper.writeMessage(message);
            }

            protected void informAboutAddingNewUser(String userName) {
                ConsoleHelper.writeMessage("User has enter the chat " + userName);
            }

            protected void informAboutDeletingNewUser(String userName) {
                ConsoleHelper.writeMessage("Ladies and Gentleman " + userName + " has left the building");
            }

            protected void notifyConnectionStatusChanged(boolean clientConnected) {
                synchronized (Client.this) {
                    Client.this.clientConnected = clientConnected;
                    Client.this.notify();
                }
            }

            protected void clientHandshake() throws IOException, ClassNotFoundException {
                Message message;

                while (!clientConnected) {
                    try {
                        message = connection.receive();
                    } catch (ClassNotFoundException e) {
                        throw new IOException("Unexpected MessageType");
                    }
                    if (message.getType() == MessageType.NAME_REQUEST) {
                        connection.send(new Message(MessageType.USER_NAME, getUserName()));
                    } else {
                        if (message.getType() == MessageType.NAME_ACCEPTED) {notifyConnectionStatusChanged(true);}
                        else throw new IOException("Unexpected MessageType");}

                }
            }

            protected void clientMainLoop() throws IOException, ClassNotFoundException {
                Message message;

                while (true) {

                    try {
                        message = connection.receive();
                    } catch (Exception e) {
                        break;
                    }
                    if (message.getType() == MessageType.TEXT) processIncomingMessage(message.getData());
                    else {
                        if (message.getType() == MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
                        else {
                            if (message.getType() == MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
                            else break;
                        }
                    }

                }
                throw new IOException("Unexpected MessageType");

            }
            @Override
            public void run(){

                try {
                    String serverAddress = getServerAddress();
                    int serverPort = getServerPort();
                    Socket socket = new Socket(serverAddress,serverPort);
                    connection = new Connection(socket);
                    clientHandshake();
                    clientMainLoop();
                } catch (IOException | ClassNotFoundException e) {
                    notifyConnectionStatusChanged(false);
                }


            }
    }
}
