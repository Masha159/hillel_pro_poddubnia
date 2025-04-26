package org.lessons.lesson29;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeDTO employee1 = new EmployeeDTO(1, "Mariia", 24, "student", 21000000);
        EmployeeDTO employee2 = new EmployeeDTO(2, "John", 25, "student", 21000);
        EmployeeDAO employeeDAO = new EmployeeDAO();
       // employeeDAO.addEmployee(employee1);
       // employeeDAO.addEmployee(employee2);
        // employeeDAO.updateEmployee(employee1);
       // employeeDAO.deleteEmployee(employee1);
        List<EmployeeDTO> employees = employeeDAO.getEmployees();
        for (EmployeeDTO employee : employees) {
            System.out.println(employee);
        }
    }
}
