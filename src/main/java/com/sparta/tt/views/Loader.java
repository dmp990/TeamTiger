package com.sparta.tt.views;

import com.sparta.tt.ConnectionManager;
import com.sparta.tt.controllers.DepartmentsRepository;
import com.sparta.tt.controllers.EmployeeDTO;
import com.sparta.tt.controllers.EmployeeDTOMapper;
import com.sparta.tt.models.FileWriter;
import com.sparta.tt.util.DateFormatValidator;
import com.sparta.tt.util.DateValidator;
import com.sparta.tt.util.DepartmentList;
import com.sparta.tt.util.DepartmentValidator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Loader {

    private static ArrayList<String> departmentList;
    private static int dept_id;
    private static String startDate;
    private static String endDate;
    private static EmployeeDTOMapper employeeDTOMapper = new EmployeeDTOMapper();


    public static void takeInput() throws SQLException {
        Scanner userInput = new Scanner(System.in);

        boolean validDepartmentInput = false;

        departmentList = DepartmentList.getDepartmentList();

        for (int i = 0; i < departmentList.toArray().length; i++) {
            System.out.println((i + 1) + " : " + departmentList.get(i));
        }

        do {
            try {
                System.out.println("Select a department number: ");
                dept_id = userInput.nextInt();


                if (!DepartmentValidator.departmentValidator(dept_id, departmentList.size())) {
                    System.out.println("Invalid input.  Please select a valid department number from 1 to " + departmentList.size());

                } else {
                    validDepartmentInput = true;
                    userInput.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input.  Please select a valid department number from 1 to " + departmentList.size());
                userInput.nextLine();
            }
        } while (!validDepartmentInput);


        do {
            System.out.println("Start Date (YYYY-MM-DD): ");
            startDate = userInput.nextLine();
            if (!DateFormatValidator.isValidDate((startDate))) {
                System.out.println("Invalid date format.  Please enter a valid start date in the format of yyyy-mm-dd");
            }

        } while (!DateFormatValidator.isValidDate(startDate));


        do {
            System.out.println("End Date (YYYY-MM-DD): ");
            endDate = userInput.nextLine();
            if (!DateFormatValidator.isValidDate(endDate)) {
                System.out.println("Invalid date format.  Please enter a valid end date in the format of yyyy-mm-dd");
            }

        } while (!DateFormatValidator.isValidDate(endDate));


    }

    public static void writeToFile() throws SQLException, IOException {
        StringBuilder filename = new StringBuilder(departmentList.get(dept_id - 1) + "_" + startDate + "_" + endDate);
        String fileFormat = "";
        while (!fileFormat.equals("1") && !fileFormat.equals("2")) {
            System.out.print("Please select a file format: (1 for .xml 2 for .json): ");
            Scanner in = new Scanner(System.in);
            fileFormat = in.nextLine();
        }
        if (fileFormat.equals("1")) {
            filename.append(".xml");
        } else {
            filename.append(".json");
        }

        ArrayList<EmployeeDTO> employees = employeeDTOMapper.getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime(departmentList.get(dept_id - 1), startDate, endDate);
        ConnectionManager.closeConnection();


        FileWriter writer = new FileWriter(filename.toString(), employees);

    }

}
