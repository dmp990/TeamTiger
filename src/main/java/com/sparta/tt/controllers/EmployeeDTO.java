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
        employeeDTOLogger.addHandler(FileHandlerConfig.getFileHandler(employeeDTOLogger.getName()));
    }

    private int emp_no;
    private String birth_date;
    private String first_name;
    private String last_name;
    private String gender;
    private String hire_date;
    private String departmentName;
    private String fromDate;
    private String toDate;

    public EmployeeDTO(int emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date, String departmentName, String fromDate, String toDate) {
        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
        this.departmentName = departmentName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        employeeDTOLogger.log(Level.FINE,"EmployeeDTO created");
    }

    public EmployeeDTO(){

    }

    public EmployeeDTO(int emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date) {
        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
      //  employeeDTOLogger.log(Level.FINE,"EmployeeDTO created");
    }

    ConsoleHandler consoleHandler = new ConsoleHandler();


    public int getEmp_no() {
        employeeDTOLogger.log(Level.INFO,"getting employee number called");
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        employeeDTOLogger.log(Level.INFO,"setting employee number called");
        this.emp_no = emp_no;
    }

    public String getBirth_date() {
        employeeDTOLogger.log(Level.INFO,"getting employee birth date called");
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        employeeDTOLogger.log(Level.INFO,"setting employee birth date called");
        this.birth_date = birth_date;
    }

    public String getFirst_name() {
        employeeDTOLogger.log(Level.INFO,"getting employee first name called");
        return first_name;
    }

    public void setFirst_name(String first_name) {
        employeeDTOLogger.log(Level.INFO,"setting employee first name called");
        this.first_name = first_name;
    }

    public String getLast_name() {
        employeeDTOLogger.log(Level.INFO,"getting employee last name called");
        return last_name;
    }

    public void setLast_name(String last_name) {
        employeeDTOLogger.log(Level.INFO,"setting employee last name called");
        this.last_name = last_name;
    }

    public String getGender() {
        employeeDTOLogger.log(Level.INFO,"getting employee gender called");
        return gender;
    }

    public void setGender(String gender) {
        employeeDTOLogger.log(Level.INFO,"setting employee gender called");
        this.gender = gender;
    }

    public String getHire_date() {
        employeeDTOLogger.log(Level.INFO,"getting employee hire date called");
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        employeeDTOLogger.log(Level.INFO,"setting employee hire date called");
        this.hire_date = hire_date;
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
                "employeeNumber=" + emp_no +
                ", birthDate='" + birth_date + '\'' +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", hireDate='" + hire_date + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }
}
