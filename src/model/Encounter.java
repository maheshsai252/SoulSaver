/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DoctorService;
import database.PatientService;
import database.VitalSignService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author somes
 */
public class Encounter {
    private VitalSigns vitalSigns;
    private String vitalSignsId;
    private Doctor doctor;
    private String doctorId;
    private Patient patient;
    private String patientId;
    private Date encounteredTime;
    private String diagnosis;
    private String type;
    private double charges;

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getDiagnosis() {
        if((this.diagnosis == null) || (this.diagnosis.equals("null")) || (this.diagnosis.isEmpty())) {
            return "NA";
        }
        return diagnosis;

    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    private String id;
    
    public Encounter(VitalSigns vitalSigns, Doctor doctor, Patient patient, String diagnosis, double charges) {
        this.vitalSigns = vitalSigns;
        this.vitalSignsId = vitalSigns.getId();
        this.doctor = doctor;
        this.doctorId = doctor.getId();
        this.patient = patient;
        this.patientId = patient.getId();
        this.setDiagnosis(diagnosis);
        this.setCharges(charges);
        this.id = UUID.randomUUID().toString();
    }

    public Encounter(String vitalSignsId, String patientId,String doctorId, Date encounteredTime, String type, double charges) {
        this.vitalSignsId = vitalSignsId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.setCharges(charges);
        this.encounteredTime = encounteredTime;
        this.type = type;
        this.id = UUID.randomUUID().toString();
    }
    public Encounter(String id,String vitalsignId, String patientId, String doctorId, Date date, String diagnosis, String type, double charges) {
        this.setDoctorId(doctorId);
        this.setEncounteredTime(date);
        this.setPatientId(patientId);
        this.setVitalSignsId(vitalsignId);
        this.setDiagnosis(diagnosis);
        this.setType(type);
        this.setCharges(charges);
        this.id = id;

    }
  
    

    public String getVitalSignsId() {
        return vitalSignsId;
    }

    public void setVitalSignsId(String vitalSignsId) {
        this.vitalSignsId = vitalSignsId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public VitalSigns getVitalSigns() {
        if(this.vitalSigns==null) {
            VitalSignService ds = new VitalSignService();
            this.vitalSigns = ds.getvitalsigns(this.vitalSignsId);
            return this.vitalSigns;
        }
        return vitalSigns;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public Doctor getDoctor() {
        System.out.println("Doctor id " + this.doctorId);
        if(this.doctorId.equals("null")) {
            return null;
        }
        if(doctor==null) {
            System.out.println("Doctor id " + this.doctorId);

            DoctorService ds = new DoctorService();
            this.doctor = ds.getDoctor(this.doctorId);
                    System.out.print("Doctor id " + this.doctor);

            return this.doctor;
        }
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        if(this.patient == null) {
            PatientService ps = new PatientService();
            this.patient = ps.getPatient(this.patientId);
            System.out.println("ret is"+this.patient);
            return this.patient;
        }
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Encounter(VitalSigns vitalSigns) {
		this.vitalSigns = vitalSigns;
    }
    
    
    public double getRevenue() {
        if(this.doctor == null) {
            return 0;
        }
        if(this.type.equals("General"))
            return this.doctor.getConsultation_charges();
        return this.doctor.getSurgery_charges();
    }
    @Override
    public String toString() {
        if(this.getDoctor() != null) {
        return this.getDoctor().getName();
        } 
        return "NA";
    }

	public Date getEncounteredTime() {
            if(this.encounteredTime == null) {
                return new Date();
            }
		return encounteredTime;
	}

	public void setEncounteredTime(Date encounteredTime) {
		this.encounteredTime = encounteredTime;
	}

	public String getCurrentTimeStamp() {

		String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
		StringBuilder sb = new StringBuilder(localDateTime);
		sb.delete(19, 23).replace(10, 11, " ");
		return sb.toString();
	}
}
