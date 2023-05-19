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

    public ArrayList<EmployeeDTO> getEmployeesArray() throws SQLException {
        employeeDTOMapperLogger.log(Level.FINE, "EmployeeDTOMapper getEmployeeArray() method called");
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        ResultSet resultSet = employeeDAO.getAllUsers();
        while (resultSet.next()) {
            int employeeNumber = resultSet.getInt(1);
            LocalDate birthDate = resultSet.getDate(2).toLocalDate();
            String firstName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            String gender = resultSet.getString(5);
            LocalDate hireDate = resultSet.getDate(6).toLocalDate();
            employeesArray.add(new EmployeeDTO(employeeNumber, birthDate.toString(), firstName, lastName, gender, hireDate.toString(), null, null, null));
            employeeDTOMapperLogger.log(Level.INFO, "Employee id - "+ employeeNumber +" added to employees array");
        }
        return employeesArray;
    }

    public ArrayList<EmployeeDTO> getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime(String dept) throws SQLException {
        employeeDTOMapperLogger.log(Level.FINE, "EmployeeDTOMapper getEmployeesFromSpecifiedDepartmentDuringSpecifiedTime() method called");
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        ResultSet resultSet = employeeDAO.getEmployeesByDepartment(dept);
        while (resultSet.next()) {
            int employeeNumber = resultSet.getInt(1);
            LocalDate birthDate = resultSet.getDate(2).toLocalDate();
            String firstName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            String gender = resultSet.getString(5);
            LocalDate hireDate = resultSet.getDate(6).toLocalDate();
            String department = resultSet.getString(7);
            LocalDate startDate = resultSet.getDate(8).toLocalDate();
            LocalDate endDate = resultSet.getDate(9).toLocalDate();
            employeesArray.add(new EmployeeDTO(employeeNumber, birthDate.toString(), firstName, lastName, gender, hireDate.toString(), department, startDate.toString(), endDate.toString()));
            employeeDTOMapperLogger.log(Level.INFO, "Employee id - "+ employeeNumber +" added to employees array");
        }
        return employeesArray;
    }
}
