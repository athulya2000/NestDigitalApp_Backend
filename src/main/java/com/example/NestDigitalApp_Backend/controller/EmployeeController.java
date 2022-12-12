package com.example.NestDigitalApp_Backend.controller;

import com.example.NestDigitalApp_Backend.dao.EmployeeDao;
import com.example.NestDigitalApp_Backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/addemployee",consumes = "application/json",produces = "application/json")
    public Map<String,String> AddEmployee(@RequestBody Employee e){
        HashMap<String,String>  map=new HashMap<>();
        dao.save(e);
        map.put("status","success");
        return map;
    }
}
