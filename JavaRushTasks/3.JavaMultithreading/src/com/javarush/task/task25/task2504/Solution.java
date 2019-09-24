package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for(Thread tread : threads) {
            switch (tread.getState()) {
                case NEW:
                    tread.start();
                    break;
                case RUNNABLE:
                    tread.isInterrupted();
                    break;
                case BLOCKED:
                    tread.interrupt();
                    break;
                case WAITING:
                    tread.interrupt();
                    break;
                case TIMED_WAITING:
                    tread.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(tread.getPriority());
                    break;
            }
        }//implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
    }
}
