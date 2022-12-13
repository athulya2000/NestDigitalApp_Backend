package com.example.NestDigitalApp_Backend.controller;

import com.example.NestDigitalApp_Backend.dao.LeaveDao;
import com.example.NestDigitalApp_Backend.model.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {
    @Autowired
    private LeaveDao daol;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/applyleave",consumes = "application/json",produces = "application/json")
    public Map<String ,String> ApplyLeave(@RequestBody Leave l){
        HashMap<String,String> map=new HashMap<>();
        int employeeid=l.getEmployeeid();
        String leavetype=l.getLeavetype().toString();
        String remarks=l.getRemarks().toString();
        String fromdate=l.getFromdate().toString();
        String todate=l.getTodate().toString();
        String leaveapplydate=l.getLeaveapplydate().toString();
        int status=l.getStatus();
        daol.save(l);
        map.put("status","success");
        return  map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewallleave")
    public List<Map<String,String>> ViewAllLeave(){
        return (List<Map<String,String>>) daol.ViewAllLeave();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/updatestatus",consumes = "application/json",produces = "application/json")
    public Map<String,String> UpdateStatus(@RequestBody Leave l)
    {
        String employeeid=String.valueOf(l.getEmployeeid());
        String status=String.valueOf(l.getStatus());
        System.out.println(employeeid);
        System.out.println(status);
        daol.UpdateStatus(l.getEmployeeid(),l.getStatus());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
}
