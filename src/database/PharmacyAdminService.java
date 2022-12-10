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
import model.Patient;
import model.PharmacyAdmin;



/**
 *
 * @author maheshsai
 */
public class PharmacyAdminService {
     Connection conn;

    public PharmacyAdminService() {
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
    
    public ArrayList<PharmacyAdmin> getAllPharmacyAdmins() {
        ArrayList<PharmacyAdmin> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM PharmacyAdmin";
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
                String pharmacy_id = result.getString("pharmacy_id");
                PharmacyAdmin h = new PharmacyAdmin(id,name,email,password);
                h.setPharmacy_id(pharmacy_id);
         
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(PharmacyAdmin p) {
        return this.insertPharmacyAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
    }
    public String insertPharmacyAdmin(String name,String id, String email,String password) {
        try {
                String sql = "INSERT INTO PharmacyAdmin (name, id, email,password) VALUES (?, ?, ?,?)";
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
                   return "A new erson was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(PharmacyAdmin p) {
        return this.updatePharmacyAdmin(p.getName(), p.getId(), p.getPassword(), p.getPharmacy_id());
    }
    public String updatePharmacyAdmin(String name,String id,String password, String pharmacy_id) {
        try {
                String sql = "Update PharmacyAdmin set name = ?, password = ?, pharmacy_id=? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(4, id);
                statement.setString(2, password);
                statement.setString(3,pharmacy_id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "PharmacyAdmin was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deletePharmacyAdmin(String id) {
        try {
                String sql = "Delete from PharmacyAdmin where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "PharmacyAdmin was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public PharmacyAdmin validatePharmacyAdmin(String email, String Password) {
        try {
                String sql = "Select * from PharmacyAdmin where email = ?";
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

                    PharmacyAdmin p = new PharmacyAdmin(id,name,emaile,password);
                    return p;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public PharmacyAdmin getPhrmacyAdmin(String id) {
        try {
                String sql = "Select * from pharmacyadmin where id = ?";
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
                    PharmacyAdmin p = new PharmacyAdmin(ide, name,emaile,password);
                    p.setPharmacy_id(result.getString("pharmacy_id"));
                    return p;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
}

