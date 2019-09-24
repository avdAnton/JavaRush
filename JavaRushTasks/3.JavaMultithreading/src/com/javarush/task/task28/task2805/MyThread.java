package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static Integer priorityCount = 1;
    public MyThread() {
        this.setPriority(priorityCount);
        priorityCount += 1;
        if(priorityCount > 10){
            priorityCount = 1;
        }
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(priorityCount);
        priorityCount += 1;
        if(priorityCount > 10){
            priorityCount = 1;
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(priorityCount);
        priorityCount += 1;
        if(priorityCount > 10){
            priorityCount = 1;
        }
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(priorityCount);
        priorityCount += 1;
        if(priorityCount > 10){
            priorityCount = 1;
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(priorityCount);
        priorityCount += 1;
        if(priorityCount > 10){
            priorityCount = 1;
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(priorityCount);
        priorityCount += 1;
        if(priorityCount > 10){
            priorityCount = 1;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(priorityCount);
        priorityCount += 1;
        if(priorityCount > 10){
            priorityCount = 1;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(priorityCount);
        priorityCount += 1;
        if(priorityCount > 10){
            priorityCount = 1;
        }
    }

}
