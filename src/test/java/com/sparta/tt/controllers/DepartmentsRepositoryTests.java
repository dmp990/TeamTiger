package com.sparta.tt.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;


public class DepartmentsRepositoryTests {
    @Test
    @DisplayName("Check if getListOfDepartments returns an array of department names")
    void checkGetListOfDepartments() throws SQLException {
        DepartmentsRepository mockRepo =  Mockito.mock(DepartmentsRepository.class);

        ArrayList<String> depts = new ArrayList<>();
        depts.add("Development");
        Mockito.when(mockRepo.getListOfDepartments()).thenReturn(depts);

        Assertions.assertEquals(depts, mockRepo.getListOfDepartments());

    }

}

