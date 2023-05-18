package com.sparta.tt.controllers;


import com.sparta.tt.FileHandlerConfig;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDTO {

    public static final Logger employeeDTOLogger = Logger.getLogger(EmployeeDTO.class.getName());
    static {
        employeeDTOLogger.setUseParentHandlers(false);
        employeeDTOLogger.setLevel(Level.ALL);
        employeeDTOLogger.addHandler(FileHandlerConfig.getFileHandler());
    }

    private int employeeNumber;
    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private String hireDate;
    private String departmentName;
    private String fromDate;
    private String toDate;

    public EmployeeDTO(int employeeNumber, String birthDate, String firstName, String lastName, String gender, String hireDate, String departmentName, String fromDate, String toDate) {
        this.employeeNumber = employeeNumber;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
        this.departmentName = departmentName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        employeeDTOLogger.log(Level.FINE,"EmployeeDTO created");
    }

    ConsoleHandler consoleHandler = new ConsoleHandler();


    public int getEmployeeNumber() {
        employeeDTOLogger.log(Level.INFO,"getting employee number called");
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        employeeDTOLogger.log(Level.INFO,"setting employee number called");
        this.employeeNumber = employeeNumber;
    }

    public String getBirthDate() {
        employeeDTOLogger.log(Level.INFO,"getting employee birth date called");
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        employeeDTOLogger.log(Level.INFO,"setting employee birth date called");
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        employeeDTOLogger.log(Level.INFO,"getting employee first name called");
        return firstName;
    }

    public void setFirstName(String firstName) {
        employeeDTOLogger.log(Level.INFO,"setting employee first name called");
        this.firstName = firstName;
    }

    public String getLastName() {
        employeeDTOLogger.log(Level.INFO,"getting employee last name called");
        return lastName;
    }

    public void setLastName(String lastName) {
        employeeDTOLogger.log(Level.INFO,"setting employee last name called");
        this.lastName = lastName;
    }

    public String getGender() {
        employeeDTOLogger.log(Level.INFO,"getting employee gender called");
        return gender;
    }

    public void setGender(String gender) {
        employeeDTOLogger.log(Level.INFO,"setting employee gender called");
        this.gender = gender;
    }

    public String getHireDate() {
        employeeDTOLogger.log(Level.INFO,"getting employee hire date called");
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        employeeDTOLogger.log(Level.INFO,"setting employee hire date called");
        this.hireDate = hireDate;
    }

    public String getDepartmentName() {
        employeeDTOLogger.log(Level.INFO,"getting employee department called");
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        employeeDTOLogger.log(Level.INFO,"setting employee department called");
        this.departmentName = departmentName;
    }

    public String getFromDate() {
        employeeDTOLogger.log(Level.INFO,"getting employee from date called");
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        employeeDTOLogger.log(Level.INFO,"setting employee from date called");
        this.fromDate = fromDate;
    }

    public String getToDate() {
        employeeDTOLogger.log(Level.INFO,"getting employee get to date called");
        return toDate;
    }

    public void setToDate(String toDate) {
        employeeDTOLogger.log(Level.INFO,"setting employee set to date called");
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        employeeDTOLogger.log(Level.INFO, "EmployeeDTO toString() method called");
        return "EmployeeDTO{" +
                "employeeNumber=" + employeeNumber +
                ", birthDate='" + birthDate + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }
}
