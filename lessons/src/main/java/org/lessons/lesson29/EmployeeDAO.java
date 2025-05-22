package org.lessons.lesson29;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.lessons.lesson29.DatabaseConnector.*;

public class EmployeeDAO {
    public void addEmployee(EmployeeDTO employee) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(employee.getId());
        params.add(employee.getName());
        params.add(employee.getAge());
        params.add(employee.getPosition());
        params.add(employee.getSalary());
        executeQuery("INSERT INTO employees (id, name, age, position, salary) VALUES (?,?,?,?,?)", params);
    }

    public void updateEmployee(EmployeeDTO employee) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(employee.getName());
        params.add(employee.getAge());
        params.add(employee.getPosition());
        params.add(employee.getSalary());
        params.add(employee.getId());
        executeQuery("UPDATE employees SET name = ?, age = ?, position = ?, salary = ? WHERE id = ?", params);
    }

    public void deleteEmployee(EmployeeDTO employee) throws SQLException {
        List<Object> params = new ArrayList<Object>();
        params.add(employee.getId());
        executeQuery("DELETE FROM employees WHERE id = ?", params);
    }

    public List<EmployeeDTO> getEmployees() throws SQLException {
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        try (Connection connection = connectToDatabase()) {
            try (PreparedStatement statement = createStatement(connection,"SELECT * FROM employees")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        EmployeeDTO employee = new EmployeeDTO();
                        employee.setId(resultSet.getInt("id"));
                        employee.setName(resultSet.getString("name"));
                        employee.setAge(resultSet.getInt("age"));
                        employee.setPosition(resultSet.getString("position"));
                        employee.setSalary(resultSet.getInt("salary"));

                        employeesDTO.add(employee);
                    }
                }
            }
        }
            return employeesDTO;
        }
    }
