package org.lessons.lesson41.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.lessons.lesson41.model.Order;
import org.lessons.lesson41.repository.OrderRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Component
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Order save(final Order order) throws SQLException {
        Objects.requireNonNull(order, "Parameter [order] must not be null!");
        return orderRepository.addOrder(order);
    }

    @Transactional(readOnly = true)
    public Order findById(final Integer id) throws SQLException {
        Objects.requireNonNull(id, "Parameter [id] must not be null!");
        return orderRepository.findById(id);
    }

    public List<Order> getAll() throws SQLException { return orderRepository.getOrders(); }
}