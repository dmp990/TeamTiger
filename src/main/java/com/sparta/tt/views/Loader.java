package com.sparta.tt.views;

import com.sparta.tt.ConnectionManager;
import com.sparta.tt.controllers.DepartmentsRepository;
import com.sparta.tt.controllers.EmployeeDTO;
import com.sparta.tt.controllers.EmployeeDTOMapper;
import com.sparta.tt.models.FileWriter;
import net.bytebuddy.asm.Advice;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Loader {

    private static ArrayList<String> departmentList = null;
    private static int dept_id = 0;

    private static String startDate;
    private static String endDate;
    private static EmployeeDTOMapper employeeDTO = new EmployeeDTOMapper();


    public static void takeInput() throws SQLException {
        Scanner in = new Scanner(System.in);
        boolean isFirstTime = true;
        do {
            if (isFirstTime) {
                isFirstTime = false;
            } else {
                System.out.println("You have chosen the wrong department. Please choose again.");
            }
            System.out.println("Choose a Department: ");
            departmentList = InputValidator.getDepartmentList();
            for (int i = 0; i < departmentList.toArray().length; i++
            ) {
                System.out.println((i + 1) + " - " + departmentList.get(i));

            }
            dept_id = in.nextInt();
            in.nextLine();
        } while (!InputValidator.departmentValidator(dept_id));

        isFirstTime = true;
        do {
            if (isFirstTime) {
                isFirstTime = false;
            } else {
                System.out.println("End date must be after the start date. Please choose again.");
            }
            System.out.println("Start Date (YYYY-MM-DD): ");
            startDate = in.nextLine();
            System.out.println("End Date (YYYY-MM-DD): ");
            endDate = in.nextLine();
        } while (!InputValidator.dateValidator(startDate, endDate));
    }

    public static void writeToFile() throws SQLException, IOException {
        StringBuilder filename = new StringBuilder(departmentList.get(dept_id - 1) + "_" + startDate + "_" + endDate);
        System.out.print("Please select a file format: (1 for .xml 2 for .json): ");
        Scanner in = new Scanner(System.in);
        String fileFormat = in.nextLine();
        if (fileFormat.equals("1")) {
            filename.append(".xml");
        } else if (fileFormat.equals("2")) {
            filename.append(".json");
        }


        ArrayList<EmployeeDTO> employees = employeeDTO.getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime(departmentList.get(dept_id - 1));
        ConnectionManager.closeConnection();

        ArrayList<EmployeeDTO> filteredEmployees = new ArrayList<>();
        LocalDate finalStartDate = LocalDate.parse(startDate);
        LocalDate finalEndDate = LocalDate.parse(endDate);
        employees.stream()
                .filter(employee -> LocalDate.parse(employee.getToDate()).compareTo(finalStartDate) >= 0 && LocalDate.parse(employee.getToDate()).compareTo(finalEndDate) <= 0)
                .forEach(employee -> filteredEmployees.add(employee));


        FileWriter writer = new FileWriter(filename.toString(), filteredEmployees);
    }

}
