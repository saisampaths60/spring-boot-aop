package com.sample.springbootaop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sample.springbootaop.model.Employee;
import com.sample.springbootaop.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> employeeList = new ArrayList<>();

	@Override
	public String addEmployee(Employee employee) {
		employeeList.add(employee);
		return "Success";
	}

	@Override
	public String deleteEmployee(String employeeId) throws Exception {
		List<Employee> filteredEmployeeList = employeeList.stream()
				.filter(item -> item.getEmployeeId().equals(employeeId)).collect(Collectors.toList());
		if (filteredEmployeeList.size() > 0) {
			Employee employee = filteredEmployeeList.get(0);
			employeeList.remove(employee);
			return "Success";
		}
		throw new Exception("Employee not present to delete");
	}

	@Override
	public Employee getEmployee(String employeeId) throws Exception {
		List<Employee> filteredEmployeeList = employeeList.stream()
				.filter(item -> item.getEmployeeId().equals(employeeId)).collect(Collectors.toList());
		if (filteredEmployeeList.size() > 0) {
			Employee employee = filteredEmployeeList.get(0);
			return employee;
		}
		throw new Exception("Employee not present");
	}

}
