package org.lessons.lesson13.Bar;

public class Order {
    Drinks drink;
    int numberOfOrder;
    String client;

    public Order (Drinks drink, int numberOfOrder, String client){
        this.drink = drink;
        this.numberOfOrder = numberOfOrder;
        this.client = client;
    }

}
