package com.employee.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmplyeeService;

import io.swagger.models.HttpMethod;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmplyeeService emplyeeService;

	@GetMapping("/")
	public ResponseEntity<List<Employee>> getallEmployee() {

		List<Employee> employees = emplyeeService.getallEmployee();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {

		Employee employee = emplyeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);

	}

	@PostMapping("/")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		Employee employee2 = emplyeeService.saveEmployee(employee);

		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		Employee employee2 = emplyeeService.updateEmployee(employee,id);
		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		
		boolean b=  emplyeeService.deleteEmployee(id);
		
		if(b==true) {
			return new ResponseEntity<String>("Employee delete sucessfully",HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("Employee not delete...",HttpStatus.OK);
		}
		 
	}
	
 
	
	

//    @DeleteMapping
//    public String delete(@RequestParam("ids") List<Integer> ids) {
//    	System.out.println(ids);
//        System.out.println("deleting");
//        emplyeeService.deleteAllBYIds(ids);
//        return String.join(",", ids.stream().map(value ->  Integer.toString(value)).collect(Collectors.toList()));
//    }


    @DeleteMapping("/")
    public String delete(@RequestBody  List<Integer> ids) {
    	System.out.println(ids);
        System.out.println("deleting");
        emplyeeService.deleteAllBYIds(ids);
        return String.join(",", ids.stream().map(value ->  Integer.toString(value)).collect(Collectors.toList()));
    }
    
}
