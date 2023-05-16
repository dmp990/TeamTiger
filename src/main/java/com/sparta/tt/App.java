package com.sparta.tt;

import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws SQLException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        ArrayList<Employee> employees =  employeeDTO.getEmployeesArray();

        for (Employee each: employees) {
            System.out.println(each);
        }
        ConnectionManager.closeConnection();
    }
}
