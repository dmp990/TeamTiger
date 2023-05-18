package com.sparta.tt.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentsDAOTests {
    DepartmentsDAO mockDao = Mockito.mock(DepartmentsDAO.class);

    @Test
    @DisplayName("Check if getListOfDepartments returns an array of department names")
    void checkGetListOfDepartments() throws SQLException {

        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.next()).thenReturn(true);

        Mockito.when(mockDao.getAllDepartments()).thenReturn(resultSet);

        Assertions.assertTrue(mockDao.getAllDepartments().next());

    }
}