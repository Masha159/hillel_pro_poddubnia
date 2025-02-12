package lesson13.Bar;

import java.util.Random;

public class Client implements Runnable {
    private final Bar  bar;
    private Drinks drink;
    private final String name;
    @Override
    public void run() {
        System.out.println("Client " + this.name + " is making the order...");
        bar.order(drink, name);
    }
    public Client (Bar bar, Drinks drink, String name){
        this.bar = bar;
        this.drink = drink;
        this.name = name;
    }
}
