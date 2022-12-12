package model;

import database.PatientService;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author madhav
 */
public class VitalSigns {
     private float ageGroup;
    private float respiratoryRate;
    private float heartRate;
    private float bloodPressure;
    private float weightInKgs;
    private Patient patient;
    private String patientId;
    private String date;
    private String id;
    
    public VitalSigns(float age, float rrate, float heartRate, float bloodPressure, float weightInKgs, String pid) {
        this.ageGroup = age;
        this.heartRate = heartRate;
        this.respiratoryRate = rrate;
        this.bloodPressure = bloodPressure;
        this.weightInKgs = weightInKgs;
        this.id = UUID.randomUUID().toString();
        this.date = new Date().toString();
        this.patientId = pid;
    }
    public VitalSigns(String id, String date, float age, float rrate, float heartRate, float bloodPressure, float weightInKgs, String pid) {
        this.ageGroup = age;
        this.heartRate = heartRate;
        this.respiratoryRate = rrate;
        this.bloodPressure = bloodPressure;
        this.weightInKgs = weightInKgs;
        this.id = id;
        this.date = date;
        this.patientId = pid;
    }
    public Patient getPatient() {
        if(this.patient == null) {
            return new PatientService().getPatient(this.patientId);
        }
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    
    public VitalSigns(ArrayList<String> vitalsign) {
        if(vitalsign.size() == 8) {
        this.id = vitalsign.get(0);
        this.ageGroup = Float.parseFloat(vitalsign.get(1));
        this.respiratoryRate = Float.parseFloat(vitalsign.get(2));
        this.heartRate = Float.parseFloat(vitalsign.get(3));
        this.bloodPressure = Float.parseFloat(vitalsign.get(4));
        this.weightInKgs = Float.parseFloat(vitalsign.get(5));
        this.setPatientId(vitalsign.get(6));
        this.setDate(vitalsign.get(7));
        }
    }
    public String[] getCsvArray() {
        return new String[] {this.getId(), String.valueOf(this.getAgeGroup()), String.valueOf(this.getRespiratoryRate()), String.valueOf(this.getHeartRate()), String.valueOf(this.getBloodPressure()),String.valueOf(this.getWeightInKgs()),this.getPatientId(), this.getDate()};

    }

    public String getDate() {
        if(this.date == null) {
            return "NA";
        }
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VitalSigns() {
        this.id = UUID.randomUUID().toString();
    }
    
    
    
    public float getAgeGroup() {
        
        return ageGroup;
    }

    public void setAgeGroup(float ageGroup) {
        this.ageGroup = ageGroup;
    }

    public float getRespiratoryRate() {
        
        return respiratoryRate;
    }

    public void setRespiratoryRate(float respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public float getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(float heartRate) {
        this.heartRate = heartRate;
    }

    public float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public float getWeightInKgs() {
        return weightInKgs;
    }

    public void setWeightInKgs(float weightInKgs) {
        this.weightInKgs = weightInKgs;
    }

   @Override
   public String toString() {
       return this.getDate();
   }

}
