package com.sparta.tt.util;

import com.sparta.tt.controllers.DepartmentsRepository;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentList {

    private static ArrayList<String> departmentList = new ArrayList<>();

    public static ArrayList<String> getDepartmentList() throws SQLException {
        DepartmentsRepository deptRepo = new DepartmentsRepository();
        departmentList = deptRepo.getListOfDepartments();
        return departmentList;
    }
}
