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
public class Event {
    String id;

    public Event(String name, Date date, String hospitalId) {
        this.name = name;
        this.date = date;
        this.hospitalId = hospitalId;
        this.id = UUID.randomUUID().toString();
    }
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Event(String id, String name, Date date, String hospitalId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.hospitalId = hospitalId;
    }
    Date date;

    @Override
    public String toString() {
        return name;
    }
    String hospitalId;
    
}
