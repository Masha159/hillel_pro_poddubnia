package org.lessons.lesson37.model;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Date date;
    private double cost;
    private List<Product> products;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
