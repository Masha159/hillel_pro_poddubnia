package lesson9.Fruit;



public class Main {
    public static void main(String[] args) {
        Box<Orange> box1 = new Box<>();
        Box<Apple> box2 = new Box<>();
        Apple[] apples = new Apple[1];
        Apple apple = new Apple();
        apples[0] = apple;
        box2.add(apples);

    }
}
