/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author madhav
 */
public class TransactionLog {
    String id;
    String inventory_item_id;
    String pharmacy_id;
    double quantity;
    String user_id;
    double cost;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    Date date;
    public TransactionLog(String inventory_item_id, String pharmacy_id, double quantity, String user_id, double cost) {
        this.inventory_item_id = inventory_item_id;
        this.pharmacy_id = pharmacy_id;
        this.quantity = quantity;
        this.user_id = user_id;
        this.cost = cost;
        this.date = new Date();
        this.id = UUID.randomUUID().toString();
    }

    public TransactionLog(String id, String inventory_item_id, String pharmacy_id, double quantity, String user_id,double cost, Date date) {
        this.id = id;
        this.inventory_item_id = inventory_item_id;
        this.pharmacy_id = pharmacy_id;
        this.quantity = quantity;
        this.user_id = user_id;
        this.cost = cost;
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInventory_item_id() {
        return inventory_item_id;
    }

    public void setInventory_item_id(String inventory_item_id) {
        this.inventory_item_id = inventory_item_id;
    }

    public String getPharmacy_id() {
        return pharmacy_id;
    }

    public void setPharmacy_id(String pharmacy_id) {
        this.pharmacy_id = pharmacy_id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
       
}
