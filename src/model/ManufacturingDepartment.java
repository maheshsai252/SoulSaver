/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author maheshsai
 */
public class ManufacturingDepartment {
    String id;
    String name;
    String pharmaceutical_id;

    public String getPharmaceutical_id() {
        return pharmaceutical_id;
    }

    public void setPharmaceutical_id(String pharmaceutical_id) {
        this.pharmaceutical_id = pharmaceutical_id;
    }
    public ManufacturingDepartment(String name, String pharmaceutical_id) {
        this.name = name;
        this.pharmaceutical_id = pharmaceutical_id;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
    @Override
    public String toString() {
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

    public ManufacturingDepartment(String id, String name, String pharmaceutical_id) {
        this.id = id;
        this.name = name;
        this.pharmaceutical_id = pharmaceutical_id;
    }
}
