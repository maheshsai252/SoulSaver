/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maheshsai
 */

public class PlanningAdmin extends Person {
    
    public PlanningAdmin(String name, String password, String email) {
        super(name, password, email, "Pharmacy Admin");
    }
    
    public PlanningAdmin(String id, String name, String email,String password) {
        super(id,name, email,password, "Pharmacy Admin");

    }
}