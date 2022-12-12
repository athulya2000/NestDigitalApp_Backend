package com.example.NestDigitalApp_Backend.dao;

import com.example.NestDigitalApp_Backend.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Query(value="SELECT `id`, `designation`, `emailid`, `employeecode`, `employeename`, `password`, `phoneno`, `salary`, `username` FROM `employee` WHERE `employeecode`= :employeecode",nativeQuery = true)
    List<Employee> SearchEmployee(@Param("employeecode") String employeecode);
    @Modifying
    @Transactional
    @Query(value="DELETE FROM `employee` WHERE `id`= :id",nativeQuery = true)
    void DeleteEmployee(@Param("id") Integer id);

    @Query(value="SELECT `id`, `designation`, `emailid`, `employeecode`, `employeename`, `password`, `phoneno`, `salary`, `username` FROM `employee` WHERE `username`= :username AND`password`= :password",nativeQuery = true)
    List<Employee> EmployeeLogin(@Param("username") String username,@Param("password") String password);


    @Query(value="SELECT `id`, `designation`, `emailid`, `employeecode`, `employeename`, `password`, `phoneno`, `salary`, `username` FROM `employee` WHERE `id`= :id",nativeQuery = true)
    List<Employee> ViewProfileEmployee(@Param("id") Integer id);
}
