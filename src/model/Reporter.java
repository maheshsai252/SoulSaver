/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author madhav
 */
public class Reporter extends Person {
    
    public Reporter(String name, String password, String email) {
        super(name, password, email, "Reporter");
    }
    
    public Reporter(String id, String name, String email,String password, String orgid) {
        super(id,name,email, password, "Reporter");
        
        this.setReporterorgid(orgid);
    }
    String reporterorgid;

    public String getReportergid() {
        return reporterorgid;
    }

    public void setReporterorgid(String reporterorgid) {
        this.reporterorgid = reporterorgid;
    }
}
