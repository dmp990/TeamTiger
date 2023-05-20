package com.sparta.tt.view;

import com.sparta.tt.ConnectionManager;
import com.sparta.tt.controllers.EmployeeDTO;
import com.sparta.tt.controllers.EmployeeDTOMapper;
import com.sparta.tt.models.FileWriter;
import com.sparta.tt.util.DateFormatValidator;
import com.sparta.tt.util.EndDateValidator;
import com.sparta.tt.util.DepartmentList;
import com.sparta.tt.util.DepartmentValidator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Loader {

    private static int dept_id;
    private static String startDate;
    private static String endDate;
    private static EmployeeDTOMapper employeeDTOMapper = new EmployeeDTOMapper();


    public static void takeInput() throws SQLException {

        Scanner userInput = new Scanner(System.in);

        boolean validDepartmentInput = false;

        List<String> departmentList = DepartmentList.getDepartmentList();

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
            System.out.println("Please enter a valid start in the format of YYYY-MM-DD: ");
            startDate = userInput.nextLine();
            if (!DateFormatValidator.isValidDate((startDate))) {
                System.out.println("Invalid date format.  Please enter a valid start date in the format of yyyy-mm-dd");
            }

        } while (!DateFormatValidator.isValidDate(startDate));

        do {
            System.out.println("Please enter an end date in the format of YYYY-MM-DD: ");
            endDate = userInput.nextLine();

            while (!DateFormatValidator.isValidDate(endDate)){
                System.out.println("Invalid date format.  Please enter a valid end date in the format of yyyy-mm-dd");
                endDate = userInput.nextLine();
            }

            if (!EndDateValidator.dateValidator(startDate, endDate)) {
                System.out.println("Invalid date.  End date must come after start date");
            }
        } while (!EndDateValidator.dateValidator(startDate, endDate));

        System.out.println("Please select a file format.");
        System.out.println("1 for html");
        System.out.println("2 for xml");
        String selectedExtension;
        selectedExtension = userInput.nextLine();
        String extension = "";
        if (selectedExtension.equals("1")) {
            extension = "json";
        } else if (selectedExtension.equals("2")) {
            extension = "xml";
        }

        String fileName = departmentList.get(dept_id - 1) + "_" + startDate + "_" + endDate;
        List<EmployeeDTO> employees = employeeDTOMapper.getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime(departmentList.get(dept_id - 1), startDate, endDate);

        try {
            FileWriter fileWriter = new FileWriter(fileName, extension, employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ConnectionManager.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


