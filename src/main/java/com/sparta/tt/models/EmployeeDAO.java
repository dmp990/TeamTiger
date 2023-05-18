package com.sparta.tt.models;

import com.sparta.tt.FileHandlerConfig;
import com.sparta.tt.controllers.EmployeeDTO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {

    public static final Logger employeeDAOLogger = Logger.getLogger(EmployeeDTO.class.getName());
    static {
        employeeDAOLogger.setUseParentHandlers(false);
        employeeDAOLogger.setLevel(Level.ALL);
        employeeDAOLogger.addHandler(FileHandlerConfig.getFileHandler());
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

    public ResultSet getAllUsers() {
        employeeDAOLogger.log(Level.INFO,"EmployeeDAO getAllUsers method called");
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            return resultSet;
        } catch (SQLException e) {
            employeeDAOLogger.log(Level.WARNING,"EmployeeDAO getAllUsers() throws SQLException");
            e.printStackTrace();
        }
        return resultSet;
    }

    public void createEmployee(int empNo, Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
        try {
            employeeDAOLogger.log(Level.INFO,"EmployeeDAO createEmployee method called");
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.CREATE);
            preparedStatement.setInt(1, empNo);
            preparedStatement.setDate(2, birthDate);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, gender);
            preparedStatement.setDate(6, hireDate);
        } catch (SQLException e) {
            employeeDAOLogger.log(Level.WARNING,"EmployeeDAO createEmployee() throws SQLException");
            e.printStackTrace();
        }
    }

    public ResultSet getEmployeesByDepartment(String department) {
        employeeDAOLogger.log(Level.INFO,"EmployeeDAO getEmployeesByDepartment() method called");
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.SELECT_BY_DEPARTMENT);
            preparedStatement.setString(1, department);
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            employeeDAOLogger.log(Level.WARNING,"EmployeeDAO getEmployeesByDepartment throws SQLException");
            e.printStackTrace();
        }
        return resultSet;
    }
}