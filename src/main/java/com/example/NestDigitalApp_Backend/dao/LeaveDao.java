package com.example.NestDigitalApp_Backend.dao;

import com.example.NestDigitalApp_Backend.model.Leave;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<Leave,Integer> {

    @Query(value="SELECT e.`employeecode`, e.`employeename`, l.leavetype,l.fromdate, l.todate, l.leaveapplydate,l.status FROM `employee` e JOIN leavenew l ON e.id=l.employeeid ",nativeQuery = true)
    List<Map<String ,String>> ViewAllLeave();
    @Modifying
    @Transactional
    @Query(value="UPDATE `leavenew` SET `status`= :status WHERE `employeeid`= :employeeid",nativeQuery = true)
    void UpdateStatus(@Param("employeeid") Integer employeeid,@Param("status") Integer status);
}
