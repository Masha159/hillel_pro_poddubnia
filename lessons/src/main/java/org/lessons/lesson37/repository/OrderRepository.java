package org.lessons.lesson37.repository;

import org.lessons.lesson37.model.Order;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private final Map<Integer, Order> orderMap = new HashMap<Integer, Order>();

    public  Order getOrderById(int id){
        return orderMap.get(id);
    }

    public Order creatOrder(Order order){
        return orderMap.put(order.getId(), order);
    }

    public Order updateOrder(Order order){
        if (getOrderById(order.getId()) == null){
            throw new RuntimeException("Order does not exist");
        }
        return orderMap.put(order.getId(), order);
    }

    public void deleteOrder(int id){
        orderMap.remove(id);
    }
}

