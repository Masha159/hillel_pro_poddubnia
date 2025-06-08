package org.lessons.lesson32.coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.addOrder("Anna");
        coffeeOrderBoard.addOrder("Dan");
        coffeeOrderBoard.addOrder("Bob");
        coffeeOrderBoard.addOrder("Mariia");
        coffeeOrderBoard.deliverOrder();
        coffeeOrderBoard.deliverOrder(3);
        coffeeOrderBoard.deliverOrder(6);
        coffeeOrderBoard.draw();
    }
}
