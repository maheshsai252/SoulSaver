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
import java.util.Date;
import model.ForecastAssignment;
import model.Hospital;
import model.Pharmacy;

/**
 *
 * @author somes
 */
public class ForecastAssignmentService {
    Connection conn;
     public ForecastAssignmentService() {
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
    
    public ArrayList<ForecastAssignment> getAllForecastAssignments() {
        ArrayList<ForecastAssignment> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM ForecastAssignment";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()) {
                String rid = result.getString("forecastorg_id");
                String id = result.getString("id");
                String hid = result.getString("hospital_id");
                String type = result.getString("type");
                ForecastAssignment e = new ForecastAssignment(id,hid,rid);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(ForecastAssignment e) {
        return this.insertForecastAssignment(e.getHid(), e.getId(), e.getRid(), e.getType());
    } 
    public String insertForecastAssignment(String hid,String id, String rid, String type) {
        try {
                String p = deleteForecastAssignment(rid, type);
                System.out.println(p);
                String sql = "INSERT INTO ForecastAssignment (id, hospital_id, forecastorg_id, type) VALUES (?, ?, ?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
                statement.setString(2, hid);
                statement.setString(3, rid);
                statement.setString(4, type);
                int rowsInserted = statement.executeUpdate();
               
                if (rowsInserted > 0) {
                   return "A new assignment was inserted successfully!";
                   
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(ForecastAssignment e) {
        return this.updateForecastAssignment(e.getHid(), e.getId(), e.getRid());
    }
    public String updateForecastAssignment(String hid,String id, String rid) {
        try {
                String sql = "Update ForecastAssignment set hospital_id= ?, forecastorg_id= ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(3, id);
                statement.setString(1, hid);
                statement.setString(2, rid);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ForecastAssignment was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteForecastAssignment(String rid, String type) {
        try {
                String sql = "Delete from ForecastAssignment where forecastorg_id = ? and type=?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, rid);
                statement.setString(2, type);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ForecastAssignment was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public ForecastAssignment getForecastAssignment(String eid) {
        try {
                String sql = "Select * from ForecastAssignment where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, eid);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String rid = result.getString("forecastorg_id");
                String id = result.getString("id");
                String hid = result.getString("hospital_id");
                                String type = result.getString("type");

                ForecastAssignment e = new ForecastAssignment(id,hid,rid,type);
                return e;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
   
     


     public ArrayList<String> getAllOrgsOfHospital(String hid) {
        ArrayList<String> al = new ArrayList<>();
        try {
            String sql = "Select * from ForecastAssignment where hospital_id=? and type=?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                
               statement.setString(1, hid);
               statement.setString(2, "Hospital");
               
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
               String rid = result.getString("forecastorg_id");
                String id = result.getString("id");
                
                al.add(rid);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
     public ArrayList<Hospital> getAllHospitalsofOrg(String rid) {
        ArrayList<Hospital> al = new ArrayList<>();
        try {
            String sql = "Select * from ForecastAssignment where forecastorg_id =  ? and type=?";
            System.out.println(rid+"type");
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, rid);
                statement.setString(2, "Hospital");
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String id = result.getString("id");
                String hid = result.getString("hospital_id");
                Hospital h = new HospitalDBService().getHospital(hid);
                
                
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
        public ArrayList<Pharmacy> getAllPharmaciesofOrg(String rid) {
        ArrayList<Pharmacy> al = new ArrayList<>();
        try {
            String sql = "Select * from ForecastAssignment where forecastorg_id =  ? and type=?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, rid);
                statement.setString(2, "Pharmacy");
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String id = result.getString("id");
                String hid = result.getString("hospital_id");
                Pharmacy h = new PharmacyService().getPharmacy(hid);
                
                
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
     
}
