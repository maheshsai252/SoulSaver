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
 * @author somes
 */
public class Doctor extends Person {
    private String hospitalId;
   private String doctororg_id;

    public String getDoctororg_id() {
        return doctororg_id;
    }

    public void setDoctororg_id(String doctororg_id) {
        this.doctororg_id = doctororg_id;
    }

    private Hospital hospital;
    private EncounterHistory encounterHistory; 
    private double consultation_charges;
    private double surgery_charges;

    public double getConsultation_charges() {
        return consultation_charges;
    }

    public void setConsultation_charges(double consultation_charges) {
        this.consultation_charges = consultation_charges;
    }

    public double getSurgery_charges() {
        return surgery_charges;
    }

    public void setSurgery_charges(double surgery_charges) {
        this.surgery_charges = surgery_charges;
    }
    
    public Doctor(String name, String password, String userName) {
       super(name,password,userName,"Doctor");
       this.id = UUID.randomUUID().toString();

    }
    public Doctor(String id, String name, String email, String password) {
       super(id,name,email,password,"Doctor");
       
    }
    public Doctor(ArrayList<String> userarray) {
        
        super(userarray.get(1),userarray.get(3),userarray.get(2),"Doctor");
        System.out.println(userarray);
        this.setId(userarray.get(0));
        this.setHospitalId(userarray.get(4));
    }
    @Override
    public String toString() {
        if(this.name.equals(null)) {
            return "NA";
        }
        return this.getName();
    }
     public EncounterHistory getEncounterHistory() {
        if(this.encounterHistory == null) {
            this.encounterHistory = new EncounterHistory(id, false);
        }
        return encounterHistory;
    }
    public void setEncounterHistory(EncounterHistory encounterHistory) {
        this.encounterHistory = encounterHistory;
    }
    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        System.out.println(hospitalId+"Setting");
        this.hospitalId = hospitalId;
    }

    public Hospital getHospital() {
        if(this.hospital == null ) {
            System.out.print(this.hospitalId);
            HospitalDBService hs = new HospitalDBService();
            return hs.getHospital(this.hospitalId);
        }
        return hospital;
    }
//    public Community getCommunity() {
//        if(this.hospitalId != null ) {
//            HospitalService hs = new HospitalService();
//            Hospital h = hs.getHospital(this.hospitalId);
//            if(h!=null) {
//                return h.getCommunity();
//            }
//        }
//        return null;
//    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
        this.hospitalId = hospital.getId();
    }
    
    public boolean verify(String password){
        if(password.equals(getPassword())) {
            return true;
        }
        return false;
    }

    

}
