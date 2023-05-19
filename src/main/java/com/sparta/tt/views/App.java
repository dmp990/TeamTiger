package com.sparta.tt.views;

import com.sparta.tt.controllers.EmployeeFileReader;

import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, IOException {
        EmployeeFileReader fr = new EmployeeFileReader("csv");
            Loader.loader();
    }
}
