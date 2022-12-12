/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author maheshsai
 */
public class Pharmacy {
    String id;
    String address;
    String email;
    String name;
    String pharmaceutical_id;

    public String getPharmaceutical_id() {
        return pharmaceutical_id;
    }

    public void setPharmaceutical_id(String pharmaceutical_id) {
        this.pharmaceutical_id = pharmaceutical_id;
    }
    public Pharmacy(String id, String address, String email, String name, String pharmaceutical_id) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.name = name;
        this.pharmaceutical_id = pharmaceutical_id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Pharmacy(String name, String address, String email,String pharmaceutical_id) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.id = UUID.randomUUID().toString();
                this.pharmaceutical_id = pharmaceutical_id;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Pharmacy(String address, String email) {
        this.address = address;
        this.email = email;
    }
    @Override
    public String toString() {
        return this.email;
    }
    
}
