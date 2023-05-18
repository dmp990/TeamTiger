package com.sparta.tt.views;

import com.sparta.tt.ConnectionManager;
import com.sparta.tt.controllers.EmployeeDTO;
import com.sparta.tt.controllers.EmployeeDTOMapper;
import com.sparta.tt.models.FileWriter;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException, IOException {
        EmployeeDTOMapper employeeDTO = new EmployeeDTOMapper();
        ArrayList<EmployeeDTO> employees = employeeDTO.getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime("Development");
        ConnectionManager.closeConnection();

        System.out.print("Filename: ");
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();

        System.out.println("Department: ");
        String department = in.nextLine();

        System.out.println("Start Date (YYYY-MM-DD): ");
        String stDate = in.nextLine();
        System.out.println("End Date (YYYY-MM-DD): ");
        String enDate = in.nextLine();

        LocalDate startDate = LocalDate.parse(stDate);
        LocalDate endDate = LocalDate.parse(enDate);

        ArrayList<EmployeeDTO> filteredEmployees = new ArrayList<>();
        employees.stream()
                .filter(employee -> LocalDate.parse(employee.getToDate()).compareTo(startDate) >= 0 && LocalDate.parse(employee.getToDate()).compareTo(endDate) <= 0)
                .forEach(employee -> filteredEmployees.add(employee));

        FileWriter writer = new FileWriter(filename, filteredEmployees);

    }
}
