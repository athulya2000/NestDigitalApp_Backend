package com.example.NestDigitalApp_Backend.dao;

import com.example.NestDigitalApp_Backend.model.VisitorsLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitorsLogDao extends CrudRepository<VisitorsLog,Integer> {

    @Query(value="SELECT `id`, `entrydatetime`, `exitdatetime`, `name`, `purpose`, `whomtomeet`, `date` FROM `visitorslog` WHERE `date`= :date",nativeQuery = true)
    List<VisitorsLog> ViewDailyVisitorsLog(@Param("date") String date);
}
