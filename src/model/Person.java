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
public class Person {
    public String password;
    public String email;
    public String role;
    public String name;
    public String id;
    public Person(String name, String password, String email, String role) {
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
    public Person(String id, String name, String email,String password, String role) {
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        
        return this.name;
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRole() {
        return role;
    }
    public String[] getCSVArray() {
        return new String[] {this.id,this.name, this.email, this.password, this.role};
    }
    
   
    
}

