/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author madhav
 */
public class ReportRequest {
    String id;
    String hid;
    Boolean status;
    Date date;
    public ReportRequest(String id, String hid, Boolean status, Date date) {
        this.id = id;
        this.hid = hid;
        this.status = status;
        this.date = date;
    }

    public ReportRequest(String hid, Boolean status, Date date) {
        this.hid = hid;
        this.status = status;
        this.date = date;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
    @Override
    public String toString() {
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
