/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author madhav
 */
public class ReporterAssignment {
    String hid;
    String rid;
    String id;
    String type;
    public ReporterAssignment(String id,String hid, String rid, String type) {
        this.hid = hid;
        this.rid = rid;
        this.type=type;
        this.id = id;
    }

    public ReporterAssignment(String hid, String rid, String type) {
        this.hid = hid;
        this.rid = rid;
        this.type = type;
        this.id = UUID.randomUUID().toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHid() {
        return hid;
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
