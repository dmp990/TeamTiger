package com.sparta.tt.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOTests {

//    @Test
//    @DisplayName("Check if getAllUsers work")
//    void CheckGetAllUsers() throws SQLException {
//        EmployeeDAO mockDAO = Mockito.mock(EmployeeDAO.class);
//        ResultSet resultSet = Mockito.mock(ResultSet.class);
//
//        Mockito.when(resultSet.getInt(1)).thenReturn(123456);
//        Mockito.when(mockDAO.getAllUsers()).thenReturn(resultSet);
//
//        Assertions.assertEquals(123456,mockDAO.getAllUsers().getInt(1));
//    }

    @Test
    @DisplayName("Check if getEmployeesByDepartment work")
    void checkGetEmployeesByDepartment() throws SQLException {
        EmployeeDAO mockDAO = Mockito.mock(EmployeeDAO.class);
        ResultSet resultSet = Mockito.mock(ResultSet.class);

        Mockito.when(resultSet.getString(1)).thenReturn("Employee in department Development");
        Mockito.when(mockDAO.getEmployeesByDepartment("Development")).thenReturn(resultSet);

        Assertions.assertEquals("Employee in department Development",mockDAO.getEmployeesByDepartment("Development").getString(1));
    }
}
