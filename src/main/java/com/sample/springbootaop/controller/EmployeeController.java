package com.sample.springbootaop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.springbootaop.model.Employee;
import com.sample.springbootaop.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<String>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/get/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable String employeeId) throws Exception {
		return new ResponseEntity<Employee>(employeeService.getEmployee(employeeId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId) throws Exception {
		return new ResponseEntity<String>(employeeService.deleteEmployee(employeeId), HttpStatus.OK);
	}

}
