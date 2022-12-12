package com.example.NestDigitalApp_Backend.controller;

import com.example.NestDigitalApp_Backend.dao.EmployeeDao;
import com.example.NestDigitalApp_Backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @CrossOrigin(origins = "*")
    @GetMapping("/viewemployee")
    public List<Employee> ViewEmployee(){
        return (List<Employee>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/searchemployee",consumes = "application/json",produces = "application/json")
    public List<Employee> Search(@RequestBody Employee e){
        String employeecode=e.getEmployeecode().toString();
        System.out.println(employeecode);
        return (List<Employee>) dao.SearchEmployee(e.getEmployeecode());
    }
}
