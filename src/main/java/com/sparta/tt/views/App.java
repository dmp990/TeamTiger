package com.sparta.tt.views;

import com.sparta.tt.ConnectionManager;
import com.sparta.tt.controllers.EmployeeDTO;
import com.sparta.tt.controllers.EmployeeDTOMapper;
import com.sparta.tt.models.FileWriter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException, IOException {
        EmployeeDTOMapper employeeDTO = new EmployeeDTOMapper();
        ArrayList<EmployeeDTO> employees =  employeeDTO.getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime("Development");
        /*for (EmployeeDTO each: employees) {
            System.out.println(each);
        }*/
        ConnectionManager.closeConnection();

        System.out.print("Filename: ");
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();
        FileWriter writer = new FileWriter(filename, employees);
    }
}
