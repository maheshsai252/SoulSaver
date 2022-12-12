/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author somes
 */
public class ForecastAssignment {
    String hid;
    String rid;
    String id;
    String type;
    public ForecastAssignment(String id,String hid, String rid, String type) {
        this.hid = hid;
        this.rid = rid;
        this.id = id;
        this.type = type;
    }

    public ForecastAssignment(String hid, String rid, String type) {
        this.hid = hid;
        this.rid = rid;
        this.id = UUID.randomUUID().toString();
        this.type = type;
    }

    public String getHid() {
        return hid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
