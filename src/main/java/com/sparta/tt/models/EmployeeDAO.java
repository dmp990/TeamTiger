package com.sparta.tt.models;

import com.sparta.tt.FileHandlerConfig;
import com.sparta.tt.controllers.EmployeeDTO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {

    public static final Logger employeeDAOLogger = Logger.getLogger(EmployeeDAO.class.getName());
    static {
        employeeDAOLogger.setUseParentHandlers(false);
        employeeDAOLogger.setLevel(Level.ALL);
        employeeDAOLogger.addHandler(FileHandlerConfig.getFileHandler(employeeDAOLogger.getName()));
    }
    private final Connection connection;
    private Statement statement;

    public EmployeeDAO(Connection connection) {
        employeeDAOLogger.log(Level.FINE,"EmployeeDAO created");
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            employeeDAOLogger.log(Level.WARNING,"EmployeeDAO throws SQLException");
            throw new RuntimeException(e);
        }
    }

    public ResultSet getEmployeesByDepartment(String department, String startDate, String endDate) {
        employeeDAOLogger.log(Level.FINE,"EmployeeDAO getEmployeesByDepartment() method called");
        ResultSet resultSet = null;
        try {
            employeeDAOLogger.log(Level.INFO,"SQLQueries statement executed (SELECT_BY_DEPARTMENT)");
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.SELECT_BY_DEPT_AND_DATE);
            preparedStatement.setString(1, department);
            preparedStatement.setString(2, startDate);
            preparedStatement.setString(3, endDate);
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            employeeDAOLogger.log(Level.WARNING,"EmployeeDAO getEmployeesByDepartment throws SQLException");
            e.printStackTrace();
        }
        return resultSet;
    }
}