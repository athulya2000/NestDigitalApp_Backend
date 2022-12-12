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

    @CrossOrigin(origins = "*")
    @PostMapping(path="/deleteemployee",consumes = "application/json",produces = "application/json")
    public Map<String,String> Delete(@RequestBody Employee e){
        HashMap<String,String> map=new HashMap<>();
        map.put("status","deleted");
        dao.DeleteEmployee(e.getId());
        return  map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/employeelogin",consumes = "application/json",produces = "application/json")
    public Map<String,String> EmployeeLogin(@RequestBody Employee e){
        HashMap<String,String> st=new HashMap<>();
        List<Employee> result=(List<Employee>) dao.EmployeeLogin(e.getUsername(),e.getPassword());
        if(result.size()==0){
            st.put("status"," Login failed");
        }else {
            int id=result.get(0).getId();
            st.put("employeeId",String.valueOf(id));
            st.put("status","Successfully login");

        }
        return st;
    }
}
