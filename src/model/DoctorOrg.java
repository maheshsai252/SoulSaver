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
public class DoctorOrg {
    String id;
    String name;
    String hospital_id;

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }
    public String getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return name;
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

    public DoctorOrg(String id, String name, String hospital_id) {
        this.id = id;
        this.name = name;
        this.hospital_id = hospital_id;
    }

    public DoctorOrg(String name, String hospital_id) {
        this.name = name;
        this.hospital_id = hospital_id;
        this.id = UUID.randomUUID().toString();
    }
    
         
}
