/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maheshsai
 */
public class ForecastOrgAdmin extends Person {
    String forecastorgid;

    public String getForecastorgid() {
        return forecastorgid;
    }

    public void setForecastorgid(String forecastorgid) {
        this.forecastorgid = forecastorgid;
    }
    
    public ForecastOrgAdmin(String id, String name, String email, String password,String orgid) {
        super(id, name, email, password, "Forecast Org Admin");
        this.setForecastorgid(orgid);
    }
     public ForecastOrgAdmin(String name, String email, String password) {
         
        super(name, email, password, "Forecast Org Admin");

    }
     
}
