package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Reporter;
import model.Hospital;
import model.Reporter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maheshsai
 */
public class ReporterService {
    Connection conn;

    public ReporterService() {
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
    
    public ArrayList<Reporter> getAllReporters() {
        ArrayList<Reporter> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM Reporter";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                String email = result.getString("email");
                String password = result.getString("password");
                String reporterorgid = result.getString("reporterorgid");
                Reporter h = new Reporter(id,name,email,password,reporterorgid);
                
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(Reporter p) {
        return this.insertReporter(p.getName(), p.getId(), p.getEmail(), p.getPassword());
    }
    public String insertReporter(String name,String id, String email,String password) {
        try {
                String sql = "INSERT INTO Reporter (name, id, email,password) VALUES (?, ?, ?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                statement.setString(3, email);
                statement.setString(4, password);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new Reporter was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(Reporter p) {
        return this.updateReporter(p.getName(), p.getId(), p.getPassword(),p.getReportergid());
    }
    public String updateReporter(String name,String id,String password, String reporterorgid) {
        try {
                String sql = "Update Reporter set name = ?, password = ?, reporterorgid = ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(4, id);
                statement.setString(2, password);
                statement.setString(3, reporterorgid);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Reporter was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteReporter(String id) {
        try {
                String sql = "Delete from Reporter where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Reporter was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public Reporter validateReporter(String email, String Password) {
        try {
                String sql = "Select * from Reporter where email = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, email);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String emaile = result.getString("email");
                    String password = result.getString("password");
                    String id = result.getString("id");
                    String reporterorgid = result.getString("reporterorgid");
                Reporter h = new Reporter(id,name,email,password,reporterorgid);
                
                    return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public Reporter getReporter(String id) {
        try {
                String sql = "Select * from Reporter where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String emaile = result.getString("email");
                    String password = result.getString("password");
                    String ide = result.getString("id");
                    String reporterorgid = result.getString("reporterorgid");
                Reporter h = new Reporter(id,name,emaile,password,reporterorgid);
                
                    return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
     public ArrayList<Reporter> getAllReportersofOrg(String id) {
         ArrayList<Reporter> al = new ArrayList<>();
        try {
                String sql = "Select * from Reporter where reporterorgid = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String emaile = result.getString("email");
                    String password = result.getString("password");
                    String ide = result.getString("id");
                    String reporterorgid = result.getString("reporterorgid");
                Reporter h = new Reporter(id,name,emaile,password,reporterorgid);
                
                    al.add(h);
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
     public ArrayList<String> getReporterHospitals(String id) {
         ArrayList<String> al = new ArrayList<>();
        try {
                String sql = "Select * from Reporter where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                HospitalDBService hs = new HospitalDBService();
                
                while(result.next()) {
                    
                    String hid = result.getString("hospital_id");
//                    Hospital h = hs.getHospital(hid);
                    al.add(hid);
                    
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
}
