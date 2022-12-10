/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author madhav
 */
public class Patient {
    private String PatientId;
    private String PatientName;
    private String HouseName;
    private String CommunityId;
    private String UserName;
    private String Pwd;
    private String HospId;

    
    public Patient() {
         this.PatientId = "123";
        this.PatientName = "pooji";
        this.HouseName = "jashn";
        this.CommunityId = "000";
        this.UserName = "Sri";
        this.Pwd = "Afidj9#";
        this.HospId="12345";
    }
    
    
    public Patient(String PatientId, String PatientName, String HouseName, String CommunityId, String UserName, String Pwd,String HospId) {
        this.PatientId = PatientId;
        this.PatientName = PatientName;
        this.HouseName = HouseName;
        this.CommunityId = CommunityId;
        this.UserName = UserName;
        this.Pwd = Pwd;
        this.HospId=HospId;
    }

    public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String PatientId) {
        this.PatientId = PatientId;
    }

    public String getHouseName() {
        return HouseName;
    }

    public void setHouseName(String HouseName) {
        this.HouseName = HouseName;
    }

    public String getCommunityId() {
        return CommunityId;
    }

    public void setCommunityId(String CommunityId) {
        this.CommunityId = CommunityId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String PatientName) {
        this.PatientName = PatientName;
    }

    public String getHospId() {
        return HospId;
    }

    public void setHospId(String HospId) {
        this.HospId = HospId;
    }
    
    @Override
    public String toString()
    {
        return PatientName;
    }
}
