package com.example.NestDigitalApp_Backend.dao;

import com.example.NestDigitalApp_Backend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Query(value="SELECT `id`, `designation`, `emailid`, `employeecode`, `employeename`, `password`, `phoneno`, `salary`, `username` FROM `employee` WHERE `employeecode`= :employeecode",nativeQuery = true)
    List<Employee> SearchEmployee(@Param("employeecode") String employeecode);
}
