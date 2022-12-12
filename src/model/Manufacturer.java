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
public class Manufacturer extends Person {
   
    String manufacturingdepartment_id;
    String address;
    public String getManufacturingdepartment_id() {
        return manufacturingdepartment_id;
    }

    public void setManufacturingdepartment_id(String manufacturingdepartment_id) {
        this.manufacturingdepartment_id = manufacturingdepartment_id;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Manufacturer(String id, String address, String email, String name, String password) {
        super(id,name,email,password,"Manufacturer");

        this.address = address;
       
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Manufacturer(String name, String password, String email) {
        super(name,password,email,"Manufacturer");
        this.id = UUID.randomUUID().toString();
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
    @Override
    public String toString() {
        return name;
    }
}
