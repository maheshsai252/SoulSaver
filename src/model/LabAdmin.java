/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.HospitalDBService;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author maheshsai
 */
public class LabAdmin extends Person {
   private String laboratory_id;

    public String getLaboratory_id() {
        return laboratory_id;
    }

    public void setLaboratory_id(String laboratory_id) {
        this.laboratory_id = laboratory_id;
    }

    private Hospital hospital;
 

 
    
    public LabAdmin(String name, String password, String userName) {
       super(name,password,userName,"LabAdmin");
       this.id = UUID.randomUUID().toString();

    }
    public LabAdmin(String id, String name, String email, String password) {
       super(id,name,email,password,"LabAdmin");
       
    }
    public LabAdmin(ArrayList<String> userarray) {
        
        super(userarray.get(1),userarray.get(3),userarray.get(2),"LabAdmin");
        System.out.println(userarray);
        this.setId(userarray.get(0));
    }
    @Override
    public String toString() {
        if(this.name.equals(null)) {
            return "NA";
        }
        return this.getName();
    }
    


 


  
    
    public boolean verify(String password){
        if(password.equals(getPassword())) {
            return true;
        }
        return false;
    }

    

}
