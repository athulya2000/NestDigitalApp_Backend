package com.example.NestDigitalApp_Backend.dao;

import com.example.NestDigitalApp_Backend.model.LeaveCounter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface LeaveCounterDao extends CrudRepository<LeaveCounter,Integer> {


    @Query(value="SELECT `id`, `casual`, `employeeid`, `seek`, `special`, `year` FROM `leavecounter` WHERE `employeeid`= :employeeid",nativeQuery = true)
    List<LeaveCounter> NoOfDays(@Param("employeeid") Integer employeeid);

    @Modifying
    @Transactional
    @Query(value="UPDATE `leavecounter` SET `casual`= :casual,`seek`= :seek,`special`= :special  WHERE `employeeid`= :employeeid",nativeQuery = true)
    void UpdateLeave(@Param("employeeid") Integer employeeid, @Param("casual") Integer casual, @Param("seek") Integer seek, @Param("special") Integer special);


    @Query(value="SELECT `id`, `casual`, `employeeid`, `seek`, `special`, `year` FROM `leavecounter` WHERE `employeeid`= :employeeid",nativeQuery = true)
    List<LeaveCounter> ViewPendingLeaves(@Param("employeeid") Integer employeeid);
}
