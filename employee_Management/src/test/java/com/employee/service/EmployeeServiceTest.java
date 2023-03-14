package com.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.employee.entity.Employee;
import com.employee.repo.EmployeeRepo;

public class EmployeeServiceTest {
	
	 @InjectMocks
	    private EmplyeeService emplyeeService;

	    @Mock
	    private EmployeeRepo employeeRepo;
	
	
//	  @Test
//	    public final void testGetById() {
//	       // final ExpiryRequestDto dto = getExpiryRequestDto();
//		  Employee emp= new Employee();
//		  final List<Employee> list = (List<Employee>) emplyeeService.getEmployeeById(1);
//	        Mockito.when(emplyeeService.getEmployeeById(Mockito.anyInt()).thenReturn((list)));
//	        
//	        assertEquals(1, list.size());
//	    }

}
