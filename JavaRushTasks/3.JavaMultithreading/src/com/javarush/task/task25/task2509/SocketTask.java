package com.javarush.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() throws IOException {
        socket.close();//close all resources here
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                try{
                    socket.close();//close all resources here by using proper SocketTask method
                } catch (IOException e) {

                }finally {
                    super.cancel(mayInterruptIfRunning);
                }
                //call super-class method in finally block
                return true;
            }
        };
    }
}