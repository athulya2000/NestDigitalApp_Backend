package com.example.NestDigitalApp_Backend.controller;

import com.example.NestDigitalApp_Backend.dao.EmployeeLogDao;
import com.example.NestDigitalApp_Backend.dao.VisitorsLogDao;
import com.example.NestDigitalApp_Backend.model.EmployeeLog;
import com.example.NestDigitalApp_Backend.model.VisitorsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {
    @Autowired
    private EmployeeLogDao dao3;
    @Autowired
    private VisitorsLogDao dao4;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployeelog", consumes = "application/json", produces = "application/json")
    public Map<String, String> AddEmployeeLog(@RequestBody EmployeeLog e) {
        Map<String, String> map = new HashMap<>();
        dao3.save(e);
        map.put("status", "employeelog added");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewallemployeelog")
    public List<EmployeeLog> Viewallemployeelog() {
        return (List<EmployeeLog>) dao3.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewdailyemployeelog", consumes = "application/json", produces = "application/json")
    public List<EmployeeLog> ViewDailyEmployeeLog(@RequestBody EmployeeLog el) {
        return (List<EmployeeLog>) dao3.ViewDailyEmployeeLog(el.getDate());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addvisitorslog", consumes = "application/json", produces = "application/json")
    public Map<String, String> AddVisitorsLog(@RequestBody VisitorsLog vl) {
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "added visitorslog");
        dao4.save(vl);
        return map;

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewallvisitorslog")
    public List<VisitorsLog> ViewAllVisitorsLog() {
        return (List<VisitorsLog>) dao4.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/viewdailyvisitorslog",consumes = "application/json", produces = "application/json")
    public List<VisitorsLog> ViewDailyVisitorsLog(@RequestBody VisitorsLog vl){
        return (List<VisitorsLog>) dao4.ViewDailyVisitorsLog(vl.getDate());
    }
}