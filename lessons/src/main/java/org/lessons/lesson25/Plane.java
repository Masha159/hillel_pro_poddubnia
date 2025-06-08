package org.lessons.lesson25;

public class Plane implements Transport{

    @Override
    public void move() {
        System.out.println("The plane is flying.");
    }

    @Override
    public void stop() {
        System.out.println("The plane stopped.");
    }
}
