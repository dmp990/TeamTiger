package com.sparta.tt.models;

public interface SQLQueries {
    String SELECT_BY_DEPT_AND_DATE = "SELECT * FROM employees.employees JOIN employees.dept_emp ON employees.employees.emp_no = employees.dept_emp.emp_no JOIN employees.departments On employees.departments.dept_no = employees.dept_emp.dept_no WHERE dept_name = ? AND from_date >= ? AND to_date <= ?";
    String SELECT_ALL_DEPARTMENTS = "SELECT dept_name FROM employees.departments";
}