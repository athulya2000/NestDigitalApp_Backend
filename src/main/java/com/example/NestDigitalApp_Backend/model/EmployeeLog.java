package com.example.NestDigitalApp_Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employeelog")
public class EmployeeLog {
    @Id
    @GeneratedValue
    private int id;
    private int employeeid;
    private String date;
    private String entrydatetime;
    private String exitdatetime;

    public EmployeeLog() {
    }

    public EmployeeLog(int id, int employeeid, String date, String entrydatetime, String exitdatetime) {
        this.id = id;
        this.employeeid = employeeid;
        this.date = date;
        this.entrydatetime = entrydatetime;
        this.exitdatetime = exitdatetime;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEntrydatetime() {
        return entrydatetime;
    }

    public void setEntrydatetime(String entrydatetime) {
        this.entrydatetime = entrydatetime;
    }

    public String getExitdatetime() {
        return exitdatetime;
    }

    public void setExitdatetime(String exitdatetime) {
        this.exitdatetime = exitdatetime;
    }
}
