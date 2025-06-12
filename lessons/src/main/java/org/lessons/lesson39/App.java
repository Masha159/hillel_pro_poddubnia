package org.lessons.lesson39;

import org.lessons.lesson39.dao.CustomerDao;
import org.lessons.lesson39.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.SQLException;


@SpringBootApplication
@EnableScheduling
public class App {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(App.class, args);
    }
}
