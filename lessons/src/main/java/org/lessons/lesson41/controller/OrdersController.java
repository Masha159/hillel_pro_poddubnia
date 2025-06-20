package org.lessons.lesson41.controller;
import org.lessons.lesson41.Service.OrderService;
import org.lessons.lesson41.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrderService orderService;

    public OrdersController(final OrderService orderService) {
        this.orderService = orderService;
    }

    public ResponseEntity<Order> get(@PathVariable Integer id) throws SQLException {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping
    public List<Order> getAll() throws SQLException {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getByIdRequest(@PathVariable("id") int id) throws SQLException {
        return orderService.findById(id);
    }

}
