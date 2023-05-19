package com.sparta.tt.controllers;

import com.sparta.tt.ConnectionManager;
import com.sparta.tt.FileHandlerConfig;
import com.sparta.tt.models.EmployeeDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDTOMapper {

    public static final Logger employeeDTOMapperLogger = Logger.getLogger(EmployeeDTOMapper.class.getName());

    static {
        employeeDTOMapperLogger.setUseParentHandlers(false);
        employeeDTOMapperLogger.setLevel(Level.ALL);
        employeeDTOMapperLogger.addHandler(FileHandlerConfig.getFileHandler(employeeDTOMapperLogger.getName()));
    }
    private ArrayList<EmployeeDTO> employeesArray = new ArrayList<>();

    public ArrayList<EmployeeDTO> getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime(String department, String startDate,String endDate) throws SQLException {
        employeeDTOMapperLogger.log(Level.FINE, "EmployeeDTOMapper getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime() method called");
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        ResultSet resultSet = employeeDAO.getEmployeesByDepartment(department, startDate, endDate);
        while (resultSet.next()) {
            int employeeNumber = resultSet.getInt(1);
            LocalDate birthDate = resultSet.getDate(2).toLocalDate();
            String firstName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            String gender = resultSet.getString(5);
            LocalDate hireDate = resultSet.getDate(6).toLocalDate();
            employeesArray.add(new EmployeeDTO(employeeNumber, birthDate.toString(), firstName, lastName, gender, hireDate.toString()));
            employeeDTOMapperLogger.log(Level.INFO, "Employee id - "+ employeeNumber +" added to employees array");
        }
        return employeesArray;
    }
}
