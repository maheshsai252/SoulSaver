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
import model.ForecastOrgAdmin;

/**
 *
 * @author maheshsai
 */
public class ForecastOrgAdminService {
    Connection conn;

    public ForecastOrgAdminService() {
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
    
    public ArrayList<ForecastOrgAdmin> getAllForecastOrgAdmins() {
        ArrayList<ForecastOrgAdmin> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM ForecastOrgAdmin";
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
                String orgid = result.getString("orgid");
                ForecastOrgAdmin h = new ForecastOrgAdmin(id,name,email,password,orgid);
                
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(ForecastOrgAdmin p) {
        return this.insertForecastOrgAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
    }
    public String insertForecastOrgAdmin(String name,String id, String email,String password) {
        try {
                String sql = "INSERT INTO ForecastOrgAdmin (name, id, email,password) VALUES (?, ?, ?,?)";
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
                   return "A new ForecastOrgAdmin was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(ForecastOrgAdmin p) {
        return this.updateForecastOrgAdmin(p.getName(), p.getId(), p.getPassword(),p.getForecastorgid());
    }
    public String updateForecastOrgAdmin(String name,String id,String password, String orgid) {
        try {
                String sql = "Update ForecastOrgAdmin set name = ?, password = ?, orgid = ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(4, id);
                statement.setString(2, password);
                statement.setString(3, orgid);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ForecastOrgAdmin was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteForecastOrgAdmin(String id) {
        try {
                String sql = "Delete from ForecastOrgAdmin where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ForecastOrgAdmin was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public ForecastOrgAdmin validateForecastOrgAdmin(String email, String Password) {
        try {
                String sql = "Select * from ForecastOrgAdmin where email = ?";
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
                    String orgid = result.getString("orgid");
                ForecastOrgAdmin h = new ForecastOrgAdmin(id,name,email,password,orgid);
                
                    return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public ForecastOrgAdmin getForecastOrgAdmin(String id) {
        try {
                String sql = "Select * from ForecastOrgAdmin where id = ?";
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
                    String orgid = result.getString("orgid");
                ForecastOrgAdmin h = new ForecastOrgAdmin(id,name,emaile,password,orgid);
                
                    return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
     public ArrayList<String> getForecastOrgAdminHospitals(String id) {
         ArrayList<String> al = new ArrayList<>();
        try {
                String sql = "Select * from ForecastOrgAdmin where id = ?";
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
