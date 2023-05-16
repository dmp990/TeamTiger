package com.sparta.tt;

public interface SQLQueries {

    String SELECT_ALL = "SELECT * from employees.employees";
    String CREATE = "INSERT INTO `employees`.`employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (?,?,?,?,?,?)";
}