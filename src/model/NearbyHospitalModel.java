/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Services.FetchGeoService;

/**
 *
 * @author maheshsai
 */
public class NearbyHospitalModel implements Comparable<NearbyHospitalModel> {
    
    Hospital hospital;
    Double distance;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public NearbyHospitalModel(Hospital hospital) {
        this.hospital = hospital;
        this.distance = FetchGeoService.calculate(hospital.getLat(), hospital.getLng());
    }
    @Override 
    public int compareTo(NearbyHospitalModel comparestu) {
        
        //  For Ascending order
        return (int) (this.distance - comparestu.distance);
 
        // For Descending order do like this
        // return compareage-this.studentage;
    }
    
}
