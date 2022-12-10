/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author somes
 */
public class Encounter {
     
    String date;
    String pid;
    String did;
    String vitalId;
    
//    pid;
//    did;
//    vitalid;
   public Encounter()
   {
       
   }
    public Encounter(String date, String pid, String did,String vitalId) {
        this.date = date;
        this.pid = pid;
        this.did = did;
        this.vitalId=vitalId;
    }
    

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVitalId() {
        return vitalId;
    }

    public void setVitalId(String vitalId) {
        this.vitalId = vitalId;
    }
    
    
      
    @Override
    public String toString()
    {
        return pid;
    }
    
}
