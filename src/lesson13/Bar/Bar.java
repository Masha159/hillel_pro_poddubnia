package lesson13.Bar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Bar {
    private List<Order> orders = new ArrayList<>();
    private Map<String, Long> ledger = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);
    private int numberOfOrder = 0;
    private boolean isOpen = true;
    /**
     * The client makes an order.
     * The method adds the order to the list and writes the information for a bill*/
    public synchronized void order(Drinks drinks, String client) {
        orders.addLast(new Order(drinks, numberOfOrder, client));
        ledger.put(client, ledger.getOrDefault(client, 0L) + drinks.price);
        numberOfOrder++;
    }

    public synchronized Order cook() {
        Order order = orders.removeFirst();
        counter.incrementAndGet();
        System.out.println("cooking the order " + order.numberOfOrder);
        return order;
    }

    public synchronized void serve(Order order) {
        counter.decrementAndGet();
        System.out.println("completed the order " + order.numberOfOrder);
    }

    public boolean hasOrders() {
        return orders.isEmpty();
    }

    public boolean isOpen() {
        return isOpen;
    }

    /**
     * The method waits for all orders to be ready and closes the bar
     */
    public boolean closeBar() {
        do  {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while ((!hasOrders() || counter.intValue() != 0));

        for (Map.Entry<String, Long> entry : ledger.entrySet()) {
            System.out.println("Client " + entry.getKey() + " paid: " + entry.getValue());
        }
        isOpen = false;
        return isOpen;
    }
}
