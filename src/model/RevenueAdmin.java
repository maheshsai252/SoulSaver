/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author madhav
 */

public class RevenueAdmin extends Person {
    
    public RevenueAdmin(String name, String password, String email) {
        super(name, password, email, "Revenue Admin");
    }
    
    public RevenueAdmin(String id, String name, String email,String password) {
        super(id,name,email, password, "Revenue Admin");

    }
}