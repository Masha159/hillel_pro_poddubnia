package org.lessons.lesson25;

public class Car implements Transport{

    @Override
    public void move() {
        System.out.println("The car is driving.");
    }

    @Override
    public void stop() {
        System.out.println("The car stopped.");
    }

}
