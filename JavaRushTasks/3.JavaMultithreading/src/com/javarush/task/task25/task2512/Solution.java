package com.javarush.task.task25.task2512;

import java.util.Stack;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Stack<Throwable> exceptions = new Stack<>();
        exceptions.push(e);
        Throwable excep = e.getCause();
        while (excep != null) {
            exceptions.push(excep);
            excep = excep.getCause();
        }
        while (!exceptions.empty())
        {
            Throwable currentException = exceptions.pop();
            System.out.println(currentException.getClass().getName() + ": " +currentException.getMessage());
        }
    }

    public static void main(String[] args) {
    }
}
