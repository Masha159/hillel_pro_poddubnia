package org.lessons.lesson9.Fruit;

public class Apple extends Fruit implements Comparable<Apple> {

    private double weightApple = 1;

    @Override
    public int compareTo(Apple o) {
        return 0;
    }


    @Override
    public double getWeight() {
        return weightApple;
    }


}
