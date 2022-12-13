package com.example.NestDigitalApp_Backend.dao;

import com.example.NestDigitalApp_Backend.model.LeaveCounter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveCounterDao extends CrudRepository<LeaveCounter,Integer> {


}
