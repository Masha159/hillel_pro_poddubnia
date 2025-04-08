package org.lessons.lesson13.Bar;

public class Main {
    public static void main(String[] args) {
        Bar bar = new Bar();
        Client client1 = new Client(bar, Drinks.COFFEE, "Jon");
        Client client2 = new Client(bar, Drinks.APEROL, "Smith");
        Client client3 = new Client(bar, Drinks.COFFEE, "Ann");
        Bartender bartender1 = new Bartender(bar);
        Bartender bartender2 = new Bartender(bar);
        new Thread(bartender1).start();
        new Thread(bartender2).start();
        new Thread(client1).start();
        new Thread(client2).start();
        new Thread(client3).start();
        bar.closeBar();
    }

}
