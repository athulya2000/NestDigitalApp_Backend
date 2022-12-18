package com.example.NestDigitalApp_Backend.controller;

import com.example.NestDigitalApp_Backend.dao.SecurityDao;
import com.example.NestDigitalApp_Backend.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao dao1;
    @CrossOrigin(origins = "*")
    @PostMapping(path="/addsecurity",consumes = "application/json",produces = "application/json")
    public Map<String,String> AddSecurity(@RequestBody Security s){
        HashMap<String,String > map=new HashMap<>();
        dao1.save(s);
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewallsecurity")
    public List<Security> ViewAllSecurity(){
        return (List<Security>) dao1.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/securitylogin",consumes = "application/json",produces = "application/json")
    public Map<String,String > SecurityLogin(@RequestBody Security s){
        HashMap<String ,String> su=new HashMap<>();
        List<Security> result=(List<Security>) dao1.SecurityLogin(s.getUsername(),s.getPassword());
        if(result.size()==0){
            su.put("status","login failed");
        }
        else {
            su.put("securityId",String.valueOf(result.get(0).getId()));
            su.put("status","successfully login");
        }
        return su;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/viewsecurityprofile",consumes = "application/json",produces = "application/json")
    public List<Security> ViewSecurity(@RequestBody Security s){
      return (List<Security>) dao1.ViewSecurityProfile(s.getId());
    }

}
