package org.lessons.lesson32.coffee.order;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CoffeeOrderBoard {
    private final List<Order> orders = new LinkedList<>();
    private int orderNum = 1;
    private final static Logger LOGGER = LogManager.getLogger(CoffeeOrderBoard.class);


    public void addOrder(String nameCustomer) {
        Order order = new Order(orderNum++, nameCustomer);
        orders.add(order);
        LOGGER.info("added order: {}", order);
    }

    public void deliverOrder() {
        if (orders.isEmpty()) {
            LOGGER.info("nothing to deliver");
        }
        Order order = orders.removeFirst();
        LOGGER.info("deliver order: {}", order);
    }

    public void deliverOrder(int orderNum) {
        Optional<Order> order = orders.stream()
                .filter(o -> o.getOrderNum() == orderNum)
                .findFirst();
        if (order.isPresent()) {
            Order orderToDeliver = order.get();
            orders.remove(orderToDeliver);
            LOGGER.info("deliver order with number: {}", orderToDeliver);
        } else {
            LOGGER.warn("nothing to deliver");
        }
    }

    public void draw() {
        System.out.println("Order | Name");
        for (Order order : orders) {
            System.out.println(order);
        }
        LOGGER.info("Order | Number of orders: {}", orders.size());
    }
}
