package org.lessons.lesson32.coffee.order;

public class Order {
    private int orderNum;
    private String name;

    public Order(int orderNum, String name) {
        this.orderNum = orderNum;
        this.name = name;
    }

    @Override
    public String toString() {
        return orderNum + " | " + name;
    }

    public int getOrderNum() {
        return orderNum;
    }
}
