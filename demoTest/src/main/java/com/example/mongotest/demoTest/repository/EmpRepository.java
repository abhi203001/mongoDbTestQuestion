package com.example.mongotest.demoTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongotest.demoTest.model.Employee;

@Repository
public interface EmpRepository extends MongoRepository<Employee,String>{

}
