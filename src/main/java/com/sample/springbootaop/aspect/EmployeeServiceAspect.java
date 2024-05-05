package com.sample.springbootaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.sample.springbootaop.model.Employee;

@Aspect
@Component
public class EmployeeServiceAspect {

	@Before(value = "execution(* com.sample.springbootaop.service.impl.EmployeeServiceImpl.*(..)) and args(employee)")
	public void beforeAdvice(JoinPoint joinPoint, Employee employee) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println("Employee: " + employee.toString());
	}

	@Before(value = "execution(* com.sample.springbootaop.service.impl.EmployeeServiceImpl.*(..)) and args(employeeId)")
	public void beforeAdvice(JoinPoint joinPoint, String employeeId) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println("Employee ID: " + employeeId);
	}

}
