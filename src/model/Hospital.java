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

public class Hospital {
    private String name;
    private String id;
//    private ArrayList<Doctor> doctorDirectory;
    private String address;
    private double balance;
    private double lat;
    private double lng;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void addBalance(double b) {
        this.setBalance(balance+b);
        
    }
    public Hospital(String name, String id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public Hospital(String name, String address) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.address = address;
    }

   
    @Override
    public String toString() {
        return this.getName();
    }
    
    public Hospital(ArrayList<String> userarray) {
        if(userarray.size() == 3) {
        this.setId(userarray.get(0));
        this.setName(userarray.get(1));
        }
    }
     
    
    public String[] getCSVArray() {
        return new String[] {this.getId(), this.getName()};
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
//    public static void main(String[] args) {
//        HospitalDBService hs = new HospitalDBService();
//        System.out.println(hs.getAllHospitals());
//        System.out.println(hs.insertHospital("test", "1", "address"));
//    }
    
}