package com.sparta.tt;

public class App {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        employeeDAO.getAllUsers();
        ConnectionManager.closeConnection();
    }
}
