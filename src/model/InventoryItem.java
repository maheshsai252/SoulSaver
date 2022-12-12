/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DoctorService;
import database.ManufacturerService;
import database.PharmacyService;
import java.util.UUID;

/**
 *
 * @author somes
 */
public class InventoryItem {
    String id;
    String name;
    int qty;
    String manufacturer_id;
    Manufacturer manfacturer;
    String Pharmacy_id;
    double cost;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    Pharmacy pharmacy;
    public InventoryItem(String name, int qty,double cost, String manufacturer_id, String Pharmacy_id) {
        this.name = name;
        this.qty = qty;
        this.manufacturer_id = manufacturer_id;
        this.Pharmacy_id = Pharmacy_id;
        this.cost = cost;
        this.id = UUID.randomUUID().toString();
    }

    public InventoryItem(String id, String name, int qty,double cost, String manufacturer_id, String Pharmacy_id) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.manufacturer_id = manufacturer_id;
        this.cost =cost;
        this.Pharmacy_id = Pharmacy_id;
    }

    @Override
    public String toString() {
        return name ;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(String manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public String getPharmacy_id() {
        return Pharmacy_id;
    }

    public void setPharmacy_id(String Pharmacy_id) {
        this.Pharmacy_id = Pharmacy_id;
    }
    public Manufacturer getManufacturer() {
        
        if(this.manfacturer==null) {

            ManufacturerService ds = new ManufacturerService();
            this.manfacturer = ds.getManufacturer(this.manufacturer_id);

            return this.manfacturer;
        }
        return this.manfacturer;
    }
    public Pharmacy getPharmacy() {
        if(this.Pharmacy_id.equals("null")) {
            return null;
        }
        if(this.pharmacy==null) {

            PharmacyService ds = new PharmacyService();
            this.pharmacy = ds.getPharmacy(this.Pharmacy_id);

            return this.pharmacy;
        }
        return this.pharmacy;
    }
}
