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
public class Patient extends Person {
    
    String address;
    private EncounterHistory encounterHistory; 


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
       
    }
    public Patient(String name, String email, String password) {
        super(UUID.randomUUID().toString(), name, email, password, "Patient");        
    }
    
    public Patient(String id, String name, String email, String password) {
        super(id, name, email, password, "Patient");        
    }
    public EncounterHistory getEncounterHistory() {
        if(this.encounterHistory == null) {
            this.encounterHistory = new EncounterHistory(id, true);
        }
        return encounterHistory;
    }
    public void setEncounterHistory(EncounterHistory encounterHistory) {
        this.encounterHistory = encounterHistory;
    }
}
