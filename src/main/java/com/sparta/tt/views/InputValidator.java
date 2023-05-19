package com.sparta.tt.views;

import com.sparta.tt.controllers.DepartmentsRepository;
import net.bytebuddy.asm.Advice;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class InputValidator {

    private static ArrayList<String> departmentList = new ArrayList<>();

    public static boolean dateValidator(String stDate, String enDate) {
        LocalDate startDate = LocalDate.parse(stDate);
        LocalDate endDate = LocalDate.parse(enDate);
        return endDate.isAfter(startDate);
    }

    public static boolean departmentValidator(int dept_id) {
        return dept_id > 0 && dept_id <= departmentList.size();
    }

    public static boolean dateRangeEmployeeFilter() {
        return true;
    }

    public static ArrayList<String> getDepartmentList() throws SQLException {
        DepartmentsRepository deptRepo = new DepartmentsRepository();
        departmentList = deptRepo.getListOfDepartments();
        return departmentList;
    }
}
