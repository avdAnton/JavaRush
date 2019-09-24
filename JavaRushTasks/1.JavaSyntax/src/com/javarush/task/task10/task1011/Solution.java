package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
       int count = 0;
        StringBuffer str = new StringBuffer(s);
       while (count < 40){
           System.out.println(str.substring(count).trim());
           count++;//напишите тут ваш код
       }
    }

}

