/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author somes
 */

public class HospitalAdmin extends Person {
    
    public HospitalAdmin(String name, String password, String email) {
        super(name, password, email, "Hospital Admin");
    }
    
    public HospitalAdmin(String id, String name, String email,String password) {
        super(id,name,email, password, "Hospital Admin");

    }
}