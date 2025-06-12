package org.lessons.lesson39.dao;

import org.lessons.lesson29.EmployeeDTO;
import org.lessons.lesson39.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.lessons.lesson29.DatabaseConnector.*;

@Component
public class CustomerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addCustomer(Customer customer) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(customer.getId());
        params.add(customer.getFullName());
        params.add(customer.getEmail());
        params.add(customer.getSocialSecurityNumber());
        jdbcTemplate.update("INSERT INTO customers (id, fullName, email, socialSecurityNumber) VALUES (?,?,?,?)", params.toArray());
    }

    public void updateCustomer(Customer customer) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(customer.getFullName());
        params.add(customer.getEmail());
        params.add(customer.getSocialSecurityNumber());
        params.add(customer.getId());
        jdbcTemplate.update("UPDATE customers SET, fullName = ?, email = ?, socialSecurityNumber = ? WHERE id = ?", params);
    }

    public void deleteCustomer(Customer customer) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(customer.getId());
        jdbcTemplate.update("DELETE FROM customers WHERE id = ?", params);
    }

    public Customer findById(Integer id) throws SQLException {
        Customer customer = new Customer();
        jdbcTemplate.query("SELECT s FROM customers s WHERE s.id = :id", new CustomerRowMapper(), id);
        return customer;
    }

    public List<Customer> getCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM customers",new CustomerRowMapper());
        return customers;
    }
}

