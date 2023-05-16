package com.sparta.tt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeDTO {
    private ArrayList<Employee> employeesArray = new ArrayList<>();

    public ArrayList<Employee> getEmployeesArray() throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        ResultSet resultSet = employeeDAO.getAllUsers();
        while (resultSet.next()) {
            int employeeNumber = resultSet.getInt(1);
            LocalDate birthDate = resultSet.getDate(2).toLocalDate();
            String firstName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            String gender = resultSet.getString(5);
            LocalDate hireDate = resultSet.getDate(6).toLocalDate();

            employeesArray.add(new Employee(employeeNumber, birthDate, firstName, lastName, gender, hireDate));
        }
        return employeesArray;
    }
}
