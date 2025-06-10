package org.lessons.lesson40.repository;

import org.lessons.lesson40.model.Order;
import org.lessons.lesson40.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {
    private final HashMap<Integer, Order> orders = new HashMap<>();
    int idCounter = 1;

    public int creatOrder(List<Product> products) {
        Order order = new Order();
        order.setId(idCounter);
        order.setProducts(products);
        orders.put(idCounter, order);
        idCounter++;
        return order.getId();
    }

    public Order getOrderById(int id){
        return orders.get(id);
    }

    public List<Order> getAll(){
        return orders.values().stream().toList();
    }

}
