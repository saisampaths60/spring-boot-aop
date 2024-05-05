package com.sample.springbootaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sample.springbootaop.model.Employee;

@Aspect
@Component
public class EmployeeServiceAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceAspect.class);

	@Before(value = "execution(* com.sample.springbootaop.service.impl.EmployeeServiceImpl.*(..)) and args(employee)")
	public void beforeAdvice(JoinPoint joinPoint, Employee employee) {
		LOGGER.info("Method: " + joinPoint.getSignature().getName());
		LOGGER.info("Before Employee: " + employee.toString());
	}

	@Before(value = "execution(* com.sample.springbootaop.service.impl.EmployeeServiceImpl.*(..)) and args(employeeId)")
	public void beforeAdvice(JoinPoint joinPoint, String employeeId) {
		LOGGER.info("Method: " + joinPoint.getSignature().getName());
		LOGGER.info("Before Employee ID: " + employeeId);
	}

	@After(value = "execution(* com.sample.springbootaop.service.impl.EmployeeServiceImpl.*(..)) and args(employee)")
	public void afterAdvice(JoinPoint joinPoint, Employee employee) {
		LOGGER.info("Method: " + joinPoint.getSignature().getName());
		LOGGER.info("After Employee: " + employee.toString());
	}

	@After(value = "execution(* com.sample.springbootaop.service.impl.EmployeeServiceImpl.*(..)) and args(employeeId)")
	public void afterAdvice(JoinPoint joinPoint, String employeeId) {
		LOGGER.info("Method: " + joinPoint.getSignature().getName());
		LOGGER.info("After Employee ID: " + employeeId);
	}

//	@Around(value = "execution(* com.sample.springbootaop.service.impl.EmployeeServiceImpl.*(..))")
//	public void aroundAdvice(ProceedingJoinPoint joinPoint) {
//		LOGGER.info("Around Method: " + joinPoint.getSignature().getName());
//		try {
//			joinPoint.proceed();
//		} catch (Throwable e) {
//			System.out.println("Exception occured: " + e);
//		}
//	}

	@AfterReturning(value = "execution(* com.sample.springbootaop.service.impl.EmployeeServiceImpl.*(..))", returning = "employee")
	public void afterReturningAdvice(JoinPoint joinPoint, Employee employee) {
		LOGGER.info("After Returning Employee: " + employee.toString());
	}

	@AfterReturning(value = "execution(* com.sample.springbootaop.service.impl.EmployeeServiceImpl.*(..))", returning = "employeeId")
	public void afterReturningAdvice(JoinPoint joinPoint, String employeeId) {
		LOGGER.info("After Returning Employee ID: " + employeeId);
	}
}
