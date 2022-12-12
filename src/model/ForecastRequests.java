/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author somes
 */
public class ForecastRequests {
     String id;
    String hid;
    Boolean status;
    Date date;
    public ForecastRequests(String id, String hid, Boolean status, Date date) {
        this.id = id;
        this.hid = hid;
        this.status = status;
        this.date = date;
    }

    public ForecastRequests(String hid, Boolean status, Date date) {
        this.hid = hid;
        this.status = status;
        this.date = date;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
