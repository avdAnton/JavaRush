package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();//напишите тут ваш код

    public Cat() {

    }

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
        Cat cat10 = new Cat(); // CСоздай 10 котов//напишите тут ваш код
        Cat.cats.add(cat1);
        Cat.cats.add(cat2);
        Cat.cats.add(cat3);
        Cat.cats.add(cat4);
        Cat.cats.add(cat5);
        Cat.cats.add(cat6);
        Cat.cats.add(cat7);
        Cat.cats.add(cat8);
        Cat.cats.add(cat9);
        Cat.cats.add(cat10);
        printCats();
    }

    public static void printCats() {
        for (Cat cat : Cat.cats){
            System.out.println(cat);//напишите тут ваш код
        }
    }
}
