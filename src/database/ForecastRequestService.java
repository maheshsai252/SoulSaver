/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.ForecastRequests;

/**
 *
 * @author maheshsai
 */
public class ForecastRequestService {
    Connection conn;

    public ForecastRequestService() {
        fetch();
    }
    
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
    
    public ArrayList<ForecastRequests> getAllForecastRequestss() {
        ArrayList<ForecastRequests> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM ForecastRequests";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String hid = result.getString("hospital_id");
                String id = result.getString("id");
                Boolean status = result.getBoolean("status");
                Date date = result.getDate("date");
                ForecastRequests h = new ForecastRequests(id,hid,status,date);
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(ForecastRequests p) {
        return this.insertForecastRequests(p.getHid(), p.getId(), p.getStatus(), p.getDate());
    }
    public String insertForecastRequests(String hid,String id, Boolean status,Date date) {
        try {
                String sql = "INSERT INTO ForecastRequests (hospital_id, id, status,date) VALUES (?, ?, ?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, hid);
                statement.setString(2, id);
                statement.setBoolean(3, status);
                statement.setDate(4, new java.sql.Date(date.getTime()));

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new reporter was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(ForecastRequests p) {
        return this.updateForecastRequests(p.getHid(), p.getId(), p.getStatus(), p.getDate());
    }
    public String updateForecastRequests(String hid,String id, Boolean status,Date date) {
        try {
                String sql = "Update ForecastRequests set hospital_id = ?, status = ?, date = ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, hid);
                statement.setString(4, id);
                statement.setBoolean(2, status);
                statement.setDate(3, new java.sql.Date(date.getTime()));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ForecastRequests was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteForecastRequests(String id) {
        try {
                String sql = "Delete from ForecastRequests where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ForecastRequests was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    
    public ForecastRequests getForecastRequests(String id) {
        try {
                String sql = "Select * from ForecastRequests where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                     String hid = result.getString("hospital_id");
                Boolean status = result.getBoolean("status");
                Date date = result.getDate("date");
                ForecastRequests h = new ForecastRequests(id,hid,status,date);
                    return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
     public ArrayList<ForecastRequests> getHospitalForecastRequestss(String id) {
         ArrayList<ForecastRequests> al = new ArrayList<>();
        try {
                String sql = "Select * from ForecastRequests where hospital_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                HospitalDBService hs = new HospitalDBService();
                
                while(result.next()) {
                    
                    String hid = result.getString("hospital_id");
                Boolean status = result.getBoolean("status");
                Date date = result.getDate("date");
                ForecastRequests h = new ForecastRequests(id,hid,status,date);
                   al.add(h);
                    
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
      public ArrayList<ForecastRequests> getOrgForecastRequestss(String rid) {
         ArrayList<ForecastRequests> al = new ArrayList<>();
        try {
            
            ArrayList<String> hsptls = new ReporterAssignmentService().getAllHospitalsofReporter(rid);
                String sql = "Select * from ForecastRequests where hospital_id in (?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                Array array = statement.getConnection().createArrayOf("VARCHAR", new Object[]{hsptls.toArray()});
                statement.setArray(1, array);
 
                ResultSet result = statement.executeQuery();
                
                while(result.next()) {
                    
                    String hid = result.getString("hospital_id");
                Boolean status = result.getBoolean("status");
                String id = result.getString("id");
                Date date = result.getDate("date");
                ForecastRequests h = new ForecastRequests(id,hid,status,date);
                   al.add(h);
                    
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
      public ArrayList<ForecastRequests> getOrgPharmacyForecastRequestss(String rid) {
         ArrayList<ForecastRequests> al = new ArrayList<>();
        try {
            
            ArrayList<String> hsptls = new ReporterAssignmentService().getAllPharmacysOfReporter(rid);
                String sql = "Select * from ForecastRequests where hospital_id in (?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                Array array = statement.getConnection().createArrayOf("VARCHAR", new Object[]{hsptls.toArray()});
                statement.setArray(1, array);
 
                ResultSet result = statement.executeQuery();
                
                while(result.next()) {
                    
                    String hid = result.getString("hospital_id");
                Boolean status = result.getBoolean("status");
                String id = result.getString("id");
                Date date = result.getDate("date");
                ForecastRequests h = new ForecastRequests(id,hid,status,date);
                   al.add(h);
                    
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
}
