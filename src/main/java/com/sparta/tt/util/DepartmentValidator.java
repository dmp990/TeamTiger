package com.sparta.tt.util;

public class DepartmentValidator {

    public static boolean departmentValidator(int dept_id, int numberOfDepartments) {
        return dept_id > 0 && dept_id <= numberOfDepartments;
    }

    public static void main(String[] args) {
        System.out.println("HELLO");
    }
}
