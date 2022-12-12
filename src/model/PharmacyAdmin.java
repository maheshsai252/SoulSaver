/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maheshsai
 */
public class PharmacyAdmin extends Person {
    String pharmacy_id;

    public String getPharmacy_id() {
        return pharmacy_id;
    }

    public void setPharmacy_id(String pharmacy_id) {
        this.pharmacy_id = pharmacy_id;
    }
    
    public PharmacyAdmin(String name, String password, String email) {
        super(name, password, email, "Pharmacy Admin");
    }
    
    public PharmacyAdmin(String id, String name, String email,String password) {
        super(id,name, email, password, "Pharmacy Admin");

    }
}
