package com.example.mongotest.demoTest.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongotest.demoTest.model.Employee;
import com.example.mongotest.demoTest.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository er;

	public String createEmployee(String name, String dept, String reportingManager, int age, int salary) {
		Employee emp = new Employee(name, dept, reportingManager, age, salary);
		er.save(emp);
		return ("New User created with ID:" + emp.getEmpId());
	}

	public List<Employee> listEmployees() {
		return er.findAll();
	}

	public String deleteEmployeeById(String id) {
		er.deleteById(id);
		return "Employee deleted";
	}

	public void updateUsers(Employee emp) {
		er.save(emp);
	}
}
