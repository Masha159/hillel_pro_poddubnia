package org.lessons.lesson13.Bar;

public class Bartender implements Runnable {
    private Bar bar;

    public Bartender (Bar bar){
        this.bar = bar;
    }
    @Override
    public void run() {
        while (bar.isOpen()) {
            if (!bar.hasOrders()) {
               Order order = bar.cook();
                System.out.println("Bartender is cooking order " + order.numberOfOrder);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                bar.serve(order);

            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
