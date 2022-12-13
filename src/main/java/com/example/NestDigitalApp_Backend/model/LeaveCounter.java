package com.example.NestDigitalApp_Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leavecounter")
public class LeaveCounter {
    @Id
    @GeneratedValue
    private int id;
    private int employeeid;
    private String year;
    private  int casual;
    private int seek;
    private int special;

    public LeaveCounter() {
    }

    public LeaveCounter(int id, int employeeid, String year, int casual, int seek, int special) {
        this.id = id;
        this.employeeid = employeeid;
        this.year = year;
        this.casual = casual;
        this.seek = seek;
        this.special = special;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCasual() {
        return casual;
    }

    public void setCasual(int casual) {
        this.casual = casual;
    }

    public int getSeek() {
        return seek;
    }

    public void setSeek(int seek) {
        this.seek = seek;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }
}

