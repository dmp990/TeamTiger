package com.sparta.tt.controllers;

import org.junit.jupiter.api.*;

public class EmployeeDTOTests {
    EmployeeDTO testEmployee = new EmployeeDTO(123456, "1990-10-10", "John", "Doe", "M", "1990-10-10", "Development", "1990-10-10", "1990-10-10");

    @Test
    @DisplayName("Check if getEmployeeNumber works correctly")
    void checkGetEmployeeNumber() {
        Assertions.assertEquals(123456, testEmployee.getEmployeeNumber());
    }

    @Test
    @DisplayName("Check if getBirthDate works correctly")
    void checkGetBirthDate() {
        Assertions.assertEquals("1990-10-10", testEmployee.getBirthDate());
    }

    @Test
    @DisplayName("Check if getFirstName works correctly")
    void checkGetFirstName() {
        Assertions.assertEquals("John", testEmployee.getFirstName());
    }

    @Test
    @DisplayName("Check if getLastName works correctly")
    void checkGetLastName() {
        Assertions.assertEquals("Doe", testEmployee.getLastName());
    }

    @Test
    @DisplayName("Check if getGender works correctly")
    void checkGetGender() {
        Assertions.assertEquals("M", testEmployee.getGender());
    }

    @Test
    @DisplayName("Check if getDepartmentName works correctly")
    void checkGetDepartmentName() {
        Assertions.assertEquals("Development", testEmployee.getDepartmentName());
    }

    @Test
    @DisplayName("Check if getHireDate works correctly")
    void checkGetHireDate() {
        Assertions.assertEquals("1990-10-10", testEmployee.getHireDate());
    }

    @Test
    @DisplayName("Check if getFromDate works correctly")
    void checkGetFromDate() {
        Assertions.assertEquals("1990-10-10", testEmployee.getFromDate());
    }

    @Test
    @DisplayName("Check if getToDate works correctly")
    void checkGetToDate() {
        Assertions.assertEquals("1990-10-10", testEmployee.getToDate());
    }
}
