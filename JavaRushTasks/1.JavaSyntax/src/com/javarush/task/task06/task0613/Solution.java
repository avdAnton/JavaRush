package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        Cat cat1 = new Cat(); // CСоздай 10 котов
        Cat cat2 = new Cat(); // CСоздай 10 котов
        Cat cat3 = new Cat(); // CСоздай 10 котов
        Cat cat4 = new Cat(); // CСоздай 10 котов
        Cat cat5 = new Cat(); // CСоздай 10 котов
        Cat cat6 = new Cat(); // CСоздай 10 котов
        Cat cat7 = new Cat(); // CСоздай 10 котов
        Cat cat8 = new Cat(); // CСоздай 10 котов
        Cat cat9 = new Cat(); // CСоздай 10 котов
        Cat cat10 = new Cat(); // CСоздай 10 котов

        System.out.println(Cat.catCount);// Выведи значение переменной catCount
    }

    public static class Cat {
        public static int catCount;
        // Создай статическую переменную catCount
     public Cat(){
         Cat.catCount++;
     }
        // Создай конструктор
    }
}
