/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maheshsai
 */

public class PharmaceuticalAdmin extends Person {
    
    public PharmaceuticalAdmin(String name, String password, String email) {
        super(name, password, email, "Pharmaceutical Admin");
    }
    
    public PharmaceuticalAdmin(String id, String name, String email,String password) {
        super(id,name, password, email, "Pharmaceutical Admin");

    }
}