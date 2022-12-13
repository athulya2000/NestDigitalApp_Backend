package com.example.NestDigitalApp_Backend.dao;

import com.example.NestDigitalApp_Backend.model.EmployeeLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeLogDao extends CrudRepository<EmployeeLog,Integer> {

  @Query(value="SELECT `id`, `date`, `employeeid`, `entrydatetime`, `exitdatetime` FROM `employeelog` WHERE `date`= :date",nativeQuery = true)
    List<EmployeeLog> ViewDailyEmployeeLog(@Param("date") String date);
}
