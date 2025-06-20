package org.lessons.lesson41.dao;

import org.lessons.lesson41.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setTotalCost(rs.getInt("totalCost"));
        order.setCreatedAt(rs.getDate("Date"));
        return order;
    }
}
