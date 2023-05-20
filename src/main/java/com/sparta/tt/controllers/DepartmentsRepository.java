package com.sparta.tt.controllers;

import com.sparta.tt.ConnectionManager;
import com.sparta.tt.models.DepartmentsDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentsRepository {
    private ArrayList<String> departments = new ArrayList<>();

    public ArrayList<String> getListOfDepartments() throws SQLException {
        DepartmentsDAO dao = new DepartmentsDAO(ConnectionManager.createConnection());
        ResultSet resultSet = dao.getAllDepartments();
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            departments.add(name);
        }
        return departments;
    }
}
