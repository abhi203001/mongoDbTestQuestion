package com.example.mongotest.demoTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongotest.demoTest.model.Employee;
import com.example.mongotest.demoTest.service.EmpService;

@RestController
@RequestMapping("/employees")
public class employeeControllers {
	@Autowired
	EmpService es;
	
	@PostMapping("/add")
	public String createEmployee(@RequestParam(name="op") String name,@RequestParam("dept") String dept, @RequestParam("reportingManager") String reportingManager,@RequestParam("age") int age,@RequestParam("salary") int salary) {
		if(null==name) {
			throw new IllegalArgumentException("{\"error\":\"At least one parameter is invalid or not supplied\"}");
		}
		return es.createEmployee(name, dept, reportingManager, age, salary);
		
			
		}
	
	@GetMapping("/list")
	public List<?> listEmployees() {
		return es.listEmployees();
	}
	
	@DeleteMapping(value = "/deleteEmpById/{id}")
	public String deleteUserById(@PathVariable(value = "id") String id) {
		return es.deleteEmployeeById(id);
	}
	
	@PutMapping(value="/update")
	public Employee update( @RequestBody  Employee emp) {
		es.updateUsers(emp);
		return emp;
	}

}
