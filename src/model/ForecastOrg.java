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
public class ForecastOrg {
    String planningep_id;
    public ForecastOrg(String name, String planningep_id) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.planningep_id=planningep_id;
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

    public ForecastOrg(String id, String name, String planningep_id) {
        this.id = id;
        this.name = name;
        this.planningep_id=planningep_id;
    }

    public String getPlanningep_id() {
        return planningep_id;
    }

    public void setPlanningep_id(String planningep_id) {
        this.planningep_id = planningep_id;
    }
}
