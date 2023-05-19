package com.sparta.tt.models;

import com.sparta.tt.FileHandlerConfig;
import com.sparta.tt.controllers.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentsDAO {

    public static final Logger departmentsDAOLogger = Logger.getLogger(EmployeeDTO.class.getName());
    static {
        departmentsDAOLogger.setUseParentHandlers(false);
        departmentsDAOLogger.setLevel(Level.ALL);
        departmentsDAOLogger.addHandler(FileHandlerConfig.getFileHandler());
    }
    private final Connection connection;
    private Statement statement;

    public DepartmentsDAO(Connection connection) {
        departmentsDAOLogger.log(Level.FINE, "DepartmentsDAO created");
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            departmentsDAOLogger.log(Level.WARNING, "DepartmentsDAO throws SQLException");
            e.printStackTrace();
        }
    }

    public ResultSet getAllDepartments() {
        departmentsDAOLogger.log(Level.INFO, "DepartmentsDAO getAllDepartments method called");
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(SQLQueries.SELECT_ALL_DEPARTMENTS);
            return resultSet;
        } catch (SQLException e) {
            departmentsDAOLogger.log(Level.WARNING,"DepartmentsDAO getAllDepartments() throws SQLException");
            e.printStackTrace();
        }
        return resultSet;
    }

}
