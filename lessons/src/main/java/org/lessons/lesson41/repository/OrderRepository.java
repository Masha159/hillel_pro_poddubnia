package org.lessons.lesson41.repository;





import org.lessons.lesson41.dao.OrderRowMapper;
import org.lessons.lesson41.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    JdbcTemplate jdbcTemplate;
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Order findById(Integer id) throws SQLException {
        Order order = new Order();
        jdbcTemplate.query("SELECT s FROM orders s WHERE s.id = :id", new OrderRowMapper(), id);
        return order;
    }

    public List<Order> getOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM orders",new OrderRowMapper());
        return orders;
    }

    public void addOrder(Order order) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(order.getId());
        params.add(order.getTotalCost());
        params.add(order.getProducts());
        params.add(order.getCreatedAt());

        jdbcTemplate.update("INSERT INTO orders (id, totalCost, products, createdAt) VALUES (?,?,?,?)", params.toArray());
    }

    public void deleteOrder(Order order) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(order.getId());
        jdbcTemplate.update("DELETE FROM orders WHERE id = ?", params);
    }

}
