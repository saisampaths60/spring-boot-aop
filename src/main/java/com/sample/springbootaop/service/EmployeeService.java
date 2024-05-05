package com.sample.springbootaop.service;

import com.sample.springbootaop.model.Employee;

public interface EmployeeService {

	String addEmployee(Employee employee);

	String deleteEmployee(String employeeId) throws Exception;

	Employee getEmployee(String employeeId) throws Exception;

}
