package com.javarush.task.task29.task2909.car;

public class Sedan extends Car {
    @Override
    public int getMaxSpeed() {
        final int MAX_SEDAN_SPEED = 120;
        return MAX_SEDAN_SPEED;
    }

    public Sedan(int numberOfPassengers) {
        super(numberOfPassengers);
    }
}
