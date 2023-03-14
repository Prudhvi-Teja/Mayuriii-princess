package com.employee.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employee.entity.Employee;

public class EmployeeControllerTest {
	
	 @Autowired
	    private MockMvc mockMvc;
	
//	  @Test
//	    public final void testSave() throws Exception {
//	         Employee emp = new Employee();
//	        emp.setName("ketan");
//	        emp.setAddress("pune");
//	        emp.setAge(28);
//	        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/").
//	                accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(emp));
//	        final MvcResult mvcResult = this.mockMvc.perform(requestBuilder).andReturn();
//	        assertEquals(200, mvcResult.getResponse().getStatus());
//	    }
//	  
//	    @Test
//	    public final void testGetEmployeeById() throws Exception {
//	        final RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/1").
//	                accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE);
//				        final MvcResult mvcResult = this.mockMvc.perform(requestBuilder).andReturn();
//	        assertEquals(200, mvcResult.getResponse().getStatus());

//}
	 }
