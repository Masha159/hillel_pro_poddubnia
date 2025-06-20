package org.lessons.lesson41.repository;

import lombok.NoArgsConstructor;
import org.lessons.lesson41.dao.OrderRowMapper;
import org.lessons.lesson41.model.Order;
import org.lessons.lesson41.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Repository
public class OrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Order findById(Integer id) throws SQLException {
        Order order = new Order();
        jdbcTemplate.query("SELECT s FROM orders s WHERE s.id = :id", new OrderRowMapper(), id);
        return order;
    }

    public List<Order> getOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM orders", new OrderRowMapper());
        return orders;
    }

    public Order addOrder(Order order) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(order.getId());
        params.add(order.getTotalCost());
        params.add(order.getCreatedAt());

        jdbcTemplate.update("INSERT INTO orders (id, total_cost, created_at) VALUES (?,?,?)", params.toArray());
        return order;
    }

    public void deleteOrder(Order order) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(order.getId());
        jdbcTemplate.update("DELETE FROM orders WHERE id = ?", params);
    }

    public void updateOrder(Order order) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(order.getId());
        params.add(order.getTotalCost());
        params.add(order.getCreatedAt());
        jdbcTemplate.update("UPDATE orders SET, id = ?, total_cost = ? WHERE created_at = ?", params);
    }

    private void insertOrderProducts(Long orderId, List<Product> products) {
        for (Product p : products) {
            jdbcTemplate.update("INSERT INTO order_products (order_id, product_id) VALUES (?, ?)",
                    orderId, p.getProductId());
        }
    }
}



