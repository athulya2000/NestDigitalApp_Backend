package com.example.NestDigitalApp_Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leavenew")
public class Leave {
    @Id
    @GeneratedValue
    private  int id;
    private int employeeid;
    private String leavetype;
    private String remarks;
    private String fromdate;
    private String todate;
    private String leaveapplydate;
    private int status;

    public Leave() {
    }

    public Leave(int id, int employeeid, String leavetype, String remarks, String fromdate, String todate, String leaveapplydate, int status) {
        this.id = id;
        this.employeeid = employeeid;
        this.leavetype = leavetype;
        this.remarks = remarks;
        this.fromdate = fromdate;
        this.todate = todate;
        this.leaveapplydate = leaveapplydate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    public String getLeaveapplydate() {
        return leaveapplydate;
    }

    public void setLeaveapplydate(String leaveapplydate) {
        this.leaveapplydate = leaveapplydate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
