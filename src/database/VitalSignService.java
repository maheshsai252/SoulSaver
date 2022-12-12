/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.VitalSigns;

/**
 *
 * @author maheshsai
 */
public class VitalSignService {
     public VitalSignService() {
        fetch();
    }
         Connection conn;

    private void fetch() {
      
        String connectionURL = "jdbc:derby://localhost:1527/sample"; //ConnectionURL, username and password should be specified in getConnection() 
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());

            conn = DriverManager.getConnection(connectionURL, "app", "app"); 
            System.out.println("Connect successfully ! ");
            
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
    }
    
    public ArrayList<VitalSigns> getAllvitalsigns() {
        ArrayList<VitalSigns> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM vitalsigns";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                 float age = Float.parseFloat(result.getString("age"));
                String id = result.getString("id");
                 float rrate = Float.parseFloat(result.getString("respiratoryrate"));
                float hrate = Float.parseFloat(result.getString("heartrate"));
                float weight = Float.parseFloat(result.getString("weightinkgs"));
                String pid = result.getString("patientid");
                float bp = Float.parseFloat(result.getString("bloodpressure"));
                String date = (result.getString("date"));
                
                VitalSigns v = new VitalSigns(id,date,age,rrate,hrate,bp,weight,pid);
                al.add(v);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(VitalSigns v) {
        return this.insertvitalsigns(v.getPatientId(), v.getId(), v.getAgeGroup(), v.getRespiratoryRate(), v.getHeartRate(), v.getWeightInKgs(), v.getBloodPressure(), v.getDate());
    }
    public String insertvitalsigns(String pid,String id, float age,float rrate,float hrate,float weight,float bp,String date) {
        try {
                String sql = "INSERT INTO vitalsigns (patientid, id, age, respiratoryrate,heartrate,weightinkgs,bloodpressure,date) VALUES (?, ?, ?,?,?,?,?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, pid);
                statement.setString(2, id);
                statement.setString(3, String.valueOf(age));
                statement.setString(4, String.valueOf(rrate));
                statement.setString(5, String.valueOf(hrate));
                statement.setString(6, String.valueOf(weight));
                statement.setString(7, String.valueOf(bp));
                statement.setString(8, date);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new vital sign was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(VitalSigns v) {
      return this.updatevitalsigns(v.getPatientId(), v.getAgeGroup(),v.getId(), v.getRespiratoryRate(), v.getHeartRate(), v.getWeightInKgs(), v.getBloodPressure(), v.getDate());

    }
    public String updatevitalsigns(String pid, float age,String id,float rrate,float hrate,float weight,float bp,String date) {
        try {
                String sql = "Update vitalsigns set patientid = ?, age = ?, respiratoryrate=?, heartrate=?,weight=?,bloodpressure=? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, pid);
                statement.setString(2, String.valueOf(age));
                statement.setString(3, String.valueOf(rrate));
                 statement.setString(4, String.valueOf(hrate));
                statement.setString(5, String.valueOf(weight));
                statement.setString(6, String.valueOf(bp));
                statement.setString(7, id);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "vitalsigns was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deletevitalsigns(String id) {
        try {
                String sql = "Delete from vitalsigns where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "vitalsigns was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public ArrayList<VitalSigns> getAllvitalsignsOfPatient(String paid) {
        ArrayList<VitalSigns> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM vitalsigns where patientid = ?";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, paid);
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                 float age = Float.parseFloat(result.getString("age"));
                String id = result.getString("id");
                 float rrate = Float.parseFloat(result.getString("respiratoryrate"));
                float hrate = Float.parseFloat(result.getString("heartrate"));
                float weight = Float.parseFloat(result.getString("weightinkgs"));
                String pid = result.getString("patientid");
                float bp = Float.parseFloat(result.getString("bloodpressure"));
                String date = (result.getString("date"));
                
                VitalSigns v = new VitalSigns(id,date,age,rrate,hrate,bp,weight,pid);
                al.add(v);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public VitalSigns getvitalsigns(String vid) {
        VitalSigns v;
        try {
             String sql = "SELECT * FROM vitalsigns where id = ?";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vid);
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                 float age = Float.parseFloat(result.getString("age"));
                String id = result.getString("id");
                 float rrate = Float.parseFloat(result.getString("respiratoryrate"));
                float hrate = Float.parseFloat(result.getString("heartrate"));
                float weight = Float.parseFloat(result.getString("weightinkgs"));
                String pid = result.getString("patientid");
                float bp = Float.parseFloat(result.getString("bloodpressure"));
                String date = (result.getString("date"));
                
                v = new VitalSigns(id,date,age,rrate,hrate,bp,weight,pid);
                return v;
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return null;

    }
}
