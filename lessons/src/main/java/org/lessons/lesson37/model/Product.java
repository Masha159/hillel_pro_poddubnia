package org.lessons.lesson37.model;

public class Product {
    private int id;
    private String name;
    private double cost;

    public Product(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
