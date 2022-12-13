package com.example.NestDigitalApp_Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="visitorslog")
public class VisitorsLog {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String purpose;
    private String whomtomeet;
    private String date;
    private String entrydatetime;
    private String exitdatetime;

    public VisitorsLog() {
    }

    public VisitorsLog(int id, String name, String purpose, String whomtomeet, String date, String entrydatetime, String exitdatetime) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
        this.whomtomeet = whomtomeet;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getWhomtomeet() {
        return whomtomeet;
    }

    public void setWhomtomeet(String whomtomeet) {
        this.whomtomeet = whomtomeet;
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