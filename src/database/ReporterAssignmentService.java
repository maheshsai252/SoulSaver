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
import model.ReporterAssignment;

/**
 *
 * @author maheshsai
 */
public class ReporterAssignmentService {
    Connection conn;
     public ReporterAssignmentService() {
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
    
    public ArrayList<ReporterAssignment> getAllReporterAssignments() {
        ArrayList<ReporterAssignment> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM ReporterAssignment";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()) {
                String rid = result.getString("reporter_id");
                String id = result.getString("id");
                String hid = result.getString("hospital_id");
                String type = result.getString("type");
                ReporterAssignment e = new ReporterAssignment(id,hid,rid);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(ReporterAssignment e) {
        return this.insertReporterAssignment(e.getHid(), e.getId(), e.getRid(), e.getType());
    } 
    public String insertReporterAssignment(String hid,String id, String rid, String type) {
        try {
                String p = deleteReporterAssignment(rid, type);
                System.out.println(p);
                String sql = "INSERT INTO ReporterAssignment (id, hospital_id, reporter_id, type) VALUES (?, ?, ?,?)";
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
    public String update(ReporterAssignment e) {
        return this.updateReporterAssignment(e.getHid(), e.getId(), e.getRid());
    }
    public String updateReporterAssignment(String hid,String id, String rid) {
        try {
                String sql = "Update ReporterAssignment set hospital_id= ?, reporter_id= ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(3, id);
                statement.setString(1, hid);
                statement.setString(2, rid);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ReporterAssignment was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteReporterAssignment(String rid, String type) {
        try {
                String sql = "Delete from ReporterAssignment where reporter_id = ? and type=?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, rid);
                statement.setString(2, type);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ReporterAssignment was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public ReporterAssignment getReporterAssignment(String eid) {
        try {
                String sql = "Select * from ReporterAssignment where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, eid);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String rid = result.getString("reporter_id");
                String id = result.getString("id");
                String hid = result.getString("hospital_id");
                                String type = result.getString("type");

                ReporterAssignment e = new ReporterAssignment(id,hid,rid,type);
                return e;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
     public ArrayList<String> getAllReportersOfHospital(String hid) {
        ArrayList<String> al = new ArrayList<>();
        try {
            String sql = "Select * from ReporterAssignment where type = ? and hospital_id=?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, "Hospital");
               statement.setString(2, hid);
               
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
               String rid = result.getString("reporter_id");
                String id = result.getString("id");
                
                al.add(rid);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
         public ArrayList<String> getAllReportersOfPharmacy(String pid) {
        ArrayList<String> al = new ArrayList<>();
        try {
            String sql = "Select * from ReporterAssignment where type = ? and hospital_id=?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, "Pharmacy");
               statement.setString(2, pid);
               
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
               String rid = result.getString("reporter_id");
                String id = result.getString("id");
                
                al.add(rid);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
     public ArrayList<String> getAllHospitalsofReporter(String rid) {
        ArrayList<String> al = new ArrayList<>();
        try {
            String sql = "Select * from ReporterAssignment where type =  ? and reporter_id =  ?";
                System.out.println(rid+"reporter");
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1,"Hospital");
                statement.setString(2, rid);
               
            ResultSet result = statement.executeQuery();
            int count = 0;
            while (result.next()){
                count+=1;
                System.out.println("1");
                String id = result.getString("id");
                String hid = result.getString("hospital_id");
                System.out.println(hid);
                al.add(hid);
            }
            System.out.println(count);
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
      public ArrayList<String> getAllPharmacysOfReporter(String rid) {
        ArrayList<String> al = new ArrayList<>();
        try {
            String sql = "Select * from ReporterAssignment where type =  ? and reporter_id =  ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1,"Pharmacy");
                statement.setString(2, rid);
               
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String id = result.getString("id");
                String hid = result.getString("hospital_id");
                
                al.add(hid);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
     
}
