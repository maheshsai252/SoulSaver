/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author madhav
 */
public class ReporterOrg {
    String revenueep_id;
    public ReporterOrg(String name, String revenueep_id) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.revenueep_id=revenueep_id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name ;
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
    String id;
    String name;

    public ReporterOrg(String id, String name, String revenueep_id) {
        this.id = id;
        this.name = name;
        this.revenueep_id=revenueep_id;
    }

    public String getRevenueep_id() {
        return revenueep_id;
    }

    public void setRevenueep_id(String revenueep_id) {
        this.revenueep_id = revenueep_id;
    }
}
