/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author somes
 */
public class HospitalAdmin {
    private String hAdminId;
    private String hAdminName;
    private String hAdminUserName;
    private String hAdminPassword;

    
    
    public HospitalAdmin(String hAdminId, String hAdminName, String hAdminUserName, String hAdminPassword) {
        this.hAdminId = hAdminId;
        this.hAdminName = hAdminName;
        this.hAdminUserName = hAdminUserName;
        this.hAdminPassword = hAdminPassword;
    }

    
    public HospitalAdmin() {
        this.hAdminId = "345";
        this.hAdminName = "Admin";
        this.hAdminUserName = "adminuser";
        this.hAdminPassword = "sdfua9";
    }

    
    
    public String gethAdminId() {
        return hAdminId;
    }

    public void sethAdminId(String hAdminId) {
        this.hAdminId = hAdminId;
    }

    public String gethAdminName() {
        return hAdminName;
    }

    public void sethAdminName(String hAdminName) {
        this.hAdminName = hAdminName;
    }

    public String gethAdminUserName() {
        return hAdminUserName;
    }

    public void sethAdminUserName(String hAdminUserName) {
        this.hAdminUserName = hAdminUserName;
    }

    public String gethAdminPassword() {
        return hAdminPassword;
    }

    public void sethAdminPassword(String hAdminPassword) {
        this.hAdminPassword = hAdminPassword;
    }
    @Override
    public String toString(){
        return hAdminId;
    }
    
}
