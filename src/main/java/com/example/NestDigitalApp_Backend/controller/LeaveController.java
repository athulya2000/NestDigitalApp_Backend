package com.example.NestDigitalApp_Backend.controller;


import com.example.NestDigitalApp_Backend.dao.LeaveCounterDao;
import com.example.NestDigitalApp_Backend.dao.LeaveDao;
import com.example.NestDigitalApp_Backend.model.Leave;
import com.example.NestDigitalApp_Backend.model.LeaveCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {
    @Autowired
    private LeaveDao daol;

    @Autowired
    private LeaveCounterDao daoc;
    int casual,seek,special;


    Date currentDate = new Date();

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyleave", consumes = "application/json", produces = "application/json")
    public Map<String, String> ApplyLeave(@RequestBody Leave l) {
        l.setLeaveapplydate(String.valueOf(currentDate));
        l.setStatus(0);
        daol.save(l);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewallleave")
    public List<Map<String, String>> ViewAllLeave() {
        return (List<Map<String, String>>) daol.ViewAllLeave();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/updatestatus", consumes = "application/json", produces = "application/json")
    public Map<String,String> Update(@RequestBody Leave l) {
        String employeeid = String.valueOf(l.getEmployeeid());
        String status=String.valueOf(l.getStatus());
        System.out.println(employeeid);
        System.out.println(status);
        daol.UpdateStatus(l.getEmployeeid(),l.getStatus());
        HashMap<String,String> s=new HashMap<>();
        s.put("status","success");
        return  s;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/viewstatus",consumes = "application/json", produces = "application/json")
    public List<Leave> ViewStatus(@RequestBody Leave l){
        String employeeid=String.valueOf(l.getEmployeeid());
        System.out.println(employeeid);
        return (List<Leave>) daol.StatusView(l.getEmployeeid());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/leavecount",consumes = "application/json", produces = "application/json")
    public Map<String,String> LeaveCount(@RequestBody Leave l) throws ParseException  {
        String employeeid=String.valueOf(l.getEmployeeid());
        List<Leave> result=(List<Leave>) daol.StatusView(l.getEmployeeid());
        l.setLeavetype(result.get(0).getLeavetype());

        LocalDate fromdate=LocalDate.parse(result.get(0).getFromdate());
        LocalDate todate=LocalDate.parse(result.get(0).getTodate());

        long daysDiff= ChronoUnit.DAYS.between(fromdate,todate);
        System.out.println("number of days between dates:"+daysDiff);

        LeaveCounter lc=new LeaveCounter();
        List<LeaveCounter> result1=(List<LeaveCounter>) daoc.NoOfDays(l.getEmployeeid());


         casual=result1.get(0).getCasual();
         seek=result1.get(0).getSeek();
         special=result1.get(0).getSpecial();


        if(l.getLeavetype().equalsIgnoreCase("casual")&& daysDiff<=casual){
            casual= (int) (casual-daysDiff);
            lc.setCasual(casual);
            seek=seek;
            special=special;

            daoc.UpdateLeave(l.getEmployeeid(),(int) casual,(int) seek,(int) special);


        } else if (l.getLeavetype().equalsIgnoreCase("seek")&& daysDiff<=seek) {
            casual=casual;
            seek= (int) (seek-daysDiff);
            lc.setSeek(seek);
            special=special;

            daoc.UpdateLeave(l.getEmployeeid(), (int) casual,(int) seek,(int) special);
        } else if (l.getLeavetype().equalsIgnoreCase("special") && daysDiff<=special) {
            casual=casual;
            seek=seek;
            special= (int) (special-daysDiff);
            lc.setSpecial(special);

            daoc.UpdateLeave(l.getEmployeeid(), (int) casual,(int) seek,(int) special);
        }else {
            HashMap<String,String> map=new HashMap<>();
            map.put("leavetype",l.getLeavetype());
            String id=String.valueOf(result1.get(0).getEmployeeid());
            map.put("employeeid",id);
            map.put("message","no leaves");
            return  map;
        }
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }


    @CrossOrigin(origins = "*")
    @PostMapping(path="/viewpendingleaves")
    public List<LeaveCounter> ViewPendingLeaves(@RequestBody LeaveCounter lc){
        String employeeid=String.valueOf(lc.getEmployeeid());
        System.out.println(employeeid);
        return (List<LeaveCounter>) daoc.ViewPendingLeaves(lc.getEmployeeid());
    }
}

