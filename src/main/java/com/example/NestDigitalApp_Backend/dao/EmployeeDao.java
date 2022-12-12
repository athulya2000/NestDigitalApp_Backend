package com.example.NestDigitalApp_Backend.dao;

import com.example.NestDigitalApp_Backend.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
