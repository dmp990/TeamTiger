package com.sparta.tt;

public interface SQLQueries {

    String SELECT_ALL = "SELECT * from employees.employees";
    String CREATE = "INSERT INTO `employees`.`employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (?,?,?,?,?,?)";

    String SELECT_BY_DEPARTMENT = "SELECT e.*, d.dept_name, de.from_date, de.to_date FROM employees.employees e JOIN employees.dept_emp de ON e.emp_no = de.emp_no JOIN employees.departments d ON de.dept_no = d.dept_no WHERE d.dept_name = ?";
}