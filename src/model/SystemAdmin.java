/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author madhav
 */
public class SystemAdmin extends Person {
    
      public SystemAdmin(String name, String password, String email) {
        super(name, password, email, "System Admin");
    }
    
    public SystemAdmin(String id, String name, String email,String password) {
        super(id,name,email, password , "System Admin");

    }
}
