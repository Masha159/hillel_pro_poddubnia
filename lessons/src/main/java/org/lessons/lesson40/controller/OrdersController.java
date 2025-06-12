package org.lessons.lesson40.controller;

import org.lessons.lesson40.model.Order;
import org.lessons.lesson40.model.Product;
import org.lessons.lesson40.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrderRepository orderRepository = new OrderRepository();

    @PostMapping
    public void createOrder(@RequestBody List<Product> products) {
        orderRepository.creatOrder(products);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @GetMapping("/{id}")
    public Order getByIdRequest(@PathVariable("id") int id) {
        return orderRepository.getOrderById(id);
    }

}
