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
    public static void loader() throws SQLException, IOException {
        EmployeeDTOMapper employeeDTO = new EmployeeDTOMapper();


        Scanner in = new Scanner(System.in);

        int dept_id = 0;
        ArrayList<String> departmentList = null;

        boolean isDepartmentInvalid = true;

        while (isDepartmentInvalid) {
            System.out.println("Choose a Department: ");
            DepartmentsRepository deptRepo = new DepartmentsRepository();
            departmentList = deptRepo.getListOfDepartments();
            for (int i = 0; i < departmentList.toArray().length; i++
            ) {
                System.out.println((i + 1) + " - " + departmentList.get(i));

            }
            dept_id = in.nextInt();
            in.nextLine();
            System.out.println(dept_id);
            if (dept_id > 0 && dept_id <= departmentList.size()) {
                isDepartmentInvalid = false;
            } else {
                System.out.println("Enter department number from the list");
            }
        }

        LocalDate startDate = LocalDate.MIN;
        LocalDate endDate = LocalDate.MAX;
        boolean isDateInvalid = true;
        while (isDateInvalid) {
            System.out.println("Start Date (YYYY-MM-DD): ");
            String stDate = in.nextLine();
            System.out.println("End Date (YYYY-MM-DD): ");
            String enDate = in.nextLine();

            try {
                startDate = LocalDate.parse(stDate);
                endDate = LocalDate.parse(enDate);
                if (endDate.isAfter(startDate)) {
                    isDateInvalid = false;
                } else {
                    System.out.println("End date must be after the start date");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Please enter a valid date in this format: (YYYY-MM-DD)");
            }
        }

        StringBuilder filename = new StringBuilder(departmentList.get(dept_id - 1) + "_" + startDate.toString() + "_" + endDate.toString());
        System.out.print("Please select a file format: (1 for .xml 2 for .json): ");
        String fileFormat = in.nextLine();
        if (fileFormat.equals("1")) {
            filename.append(".xml");
        } else if (fileFormat.equals("2")) {
            filename.append(".json");
        }


        ArrayList<EmployeeDTO> employees = employeeDTO.getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime(departmentList.get(dept_id - 1));
        ConnectionManager.closeConnection();

        ArrayList<EmployeeDTO> filteredEmployees = new ArrayList<>();
        LocalDate finalStartDate = startDate;
        LocalDate finalEndDate = endDate;
        employees.stream()
                .filter(employee -> LocalDate.parse(employee.getToDate()).compareTo(finalStartDate) >= 0 && LocalDate.parse(employee.getToDate()).compareTo(finalEndDate) <= 0)
                .forEach(employee -> filteredEmployees.add(employee));



        FileWriter writer = new FileWriter(filename.toString(), filteredEmployees);

    }

}
