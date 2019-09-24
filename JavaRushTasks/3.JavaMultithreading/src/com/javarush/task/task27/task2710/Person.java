package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
           Thread.sleep(1000);
            mail.setText("Person [" + name + "] wrote an email 'AAA'");
            synchronized (mail) {
                mail.notifyAll();
            }//сделайте что-то тут - do something here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
