package com.sparta.tt.views;

import com.sparta.tt.ConnectionManager;
import com.sparta.tt.controllers.EmployeeDTO;
import com.sparta.tt.controllers.EmployeeDTOMapper;
import com.sparta.tt.models.FileWriter;
import com.sparta.tt.util.DateFormatValidator;
import com.sparta.tt.util.DateValidator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader {

    private static ArrayList<String> departmentList = null;
    private static int dept_id = 0;
    private static String startDate;
    private static String endDate;
    private static EmployeeDTOMapper employeeDTOMapper = new EmployeeDTOMapper();


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


            System.out.println("Start Date (YYYY-MM-DD): ");
            startDate = in.nextLine();

            while(!DateFormatValidator.isValidDate(startDate)){
                    System.out.println("Invalid date format.  Please enter a valid start date in the format of yyyy-mm-dd");
                    startDate = in.nextLine();
            }

            System.out.println("End Date (YYYY-MM-DD): ");
            endDate = in.nextLine();

            while(!DateFormatValidator.isValidDate(endDate)){
                System.out.println("Invalid date format.  Please enter a valid end date in the format of yyyy-mm-dd");
                endDate = in.nextLine();
            };

            while(!DateValidator.dateValidator(startDate, endDate)) {
                System.out.println("End date must be greater than start date. Please enter a valid end date in the format of yyyy-mm-dd");
                endDate = in.nextLine();
            }

    }

    public static void writeToFile() throws SQLException, IOException {
        StringBuilder filename = new StringBuilder(departmentList.get(dept_id - 1) + "_" + startDate + "_" + endDate);
        String fileFormat = "";
        while (!fileFormat.equals("1") && !fileFormat.equals("2")){
            System.out.print("Please select a file format: (1 for .xml 2 for .json): ");
            Scanner in = new Scanner(System.in);
            fileFormat = in.nextLine();
        }
        if (fileFormat.equals("1")) {
            filename.append(".xml");
        } else  {
            filename.append(".json");
        }

        ArrayList<EmployeeDTO> employees =  employeeDTOMapper.getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime(departmentList.get(dept_id - 1), startDate, endDate);
        ConnectionManager.closeConnection();
       

        FileWriter writer = new FileWriter(filename.toString(), employees);

    }

}
