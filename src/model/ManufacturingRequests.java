/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.InventoryItemService;
import database.ManufacturerService;
import database.PharmacyService;
import java.util.UUID;

/**
 *
 * @author maheshsai
 */
public class ManufacturingRequests {
     String id;
    String name;
    int qty;
    String manufacturer_id;
    Manufacturer manfacturer;
    String Pharmacy_id;
    Pharmacy pharmacy;
    String inventory_item_id;
    InventoryItem inventoryitem;
    public ManufacturingRequests(String name, int qty, String manufacturer_id, String Pharmacy_id, String inventory_item_id) {
        this.name = name;
        this.qty = qty;
        this.manufacturer_id = manufacturer_id;
        this.Pharmacy_id = Pharmacy_id;
        this.inventory_item_id = inventory_item_id;
        this.id = UUID.randomUUID().toString();
    }

    public ManufacturingRequests(String id, String name, int qty, String manufacturer_id, String Pharmacy_id, String inventory_item_id) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.manufacturer_id = manufacturer_id;
        this.Pharmacy_id = Pharmacy_id;
        this.inventory_item_id = inventory_item_id;
    }

    public String getInventory_item_id() {
        return inventory_item_id;
    }

    public void setInventory_item_id(String inventory_item_id) {
        this.inventory_item_id = inventory_item_id;
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
        if(this.manufacturer_id.equals("null")) {
            return null;
        }
        if(this.manfacturer==null) {

            ManufacturerService ds = new ManufacturerService();
            this.manfacturer = ds.getManufacturer(this.manufacturer_id);
            System.out.println("getting manufacturer" + manufacturer_id+manfacturer);
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
    public InventoryItem getInventoryItem() {
        if(this.inventory_item_id.equals("null")) {
            return null;
        }
        if(this.inventoryitem==null) {

            InventoryItemService ds = new InventoryItemService();
            this.inventoryitem = ds.getInventoryItem(this.inventory_item_id);

            return this.inventoryitem;
        }
        return this.inventoryitem;
    }
    @Override
    public String toString() {
        return name;
    }
}
