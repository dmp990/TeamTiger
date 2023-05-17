package com.sparta.tt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws SQLException {
        EmployeeDTOMapper employeeDTO = new EmployeeDTOMapper();
        ArrayList<EmployeeDTO> employees =  employeeDTO.getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime("Development");

        for (EmployeeDTO each: employees) {
            System.out.println(each);
        }


        ConnectionManager.closeConnection();
    }
}
