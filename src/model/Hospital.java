/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author madhav
 */
public class Hospital {
    private String hospitalId;
    private String hospitalName;
    private String communityId;

    public Hospital() {
        this.hospitalId = "234";
        this.hospitalName = "Apollo";
        this.communityId = "3456";
    }

    public Hospital(String hospitalId, String hospitalName, String communityId) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.communityId = communityId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }
    @Override
    public String toString(){
        return hospitalId;
    }
    
    
}
