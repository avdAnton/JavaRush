package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread thread;
    public LoggingStateThread(Thread thread) {
        this.thread = thread;

    }

    @Override
    public void run() {
        State state = this.thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED) {
            if (this.thread.getState() != state) {
                state = this.thread.getState();
                System.out.println(state);
            }
        }
    }
}
