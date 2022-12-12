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
import model.PharmaceuticalAdmin;

/**
 *
 * @author maheshsai
 */
public class PharmaceuticalAdminService {
      Connection conn;

    public PharmaceuticalAdminService() {
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
    
    public ArrayList<PharmaceuticalAdmin> getAllPharmaceuticalAdmins() {
        ArrayList<PharmaceuticalAdmin> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM PharmaceuticalAdmin";
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
                PharmaceuticalAdmin h = new PharmaceuticalAdmin(id,name,email,password);
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(PharmaceuticalAdmin p) {
        return this.insertPharmaceuticalAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
    }
    public String insertPharmaceuticalAdmin(String name,String id, String email,String password) {
        try {
                String sql = "INSERT INTO PharmaceuticalAdmin (name, id, email,password) VALUES (?, ?, ?,?)";
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
                   return "A new person was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(PharmaceuticalAdmin p) {
        return this.updatePharmaceuticalAdmin(p.getName(), p.getId(), p.getPassword());
    }
    public String updatePharmaceuticalAdmin(String name,String id,String password) {
        try {
                String sql = "Update PharmaceuticalAdmin set name = ?, password = ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(3, id);
                statement.setString(2, password);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "PharmaceuticalAdmin was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deletePharmaceuticalAdmin(String id) {
        try {
                String sql = "Delete from PharmaceuticalAdmin where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "PharmaceuticalAdmin was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public PharmaceuticalAdmin validatePharmaceuticalAdmin(String email, String Password) {
        try {
                String sql = "Select * from PharmaceuticalAdmin where email = ?";
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

                    PharmaceuticalAdmin p = new PharmaceuticalAdmin(id,name,emaile,password);
                    return p;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public PharmaceuticalAdmin getPharmaceuticalAdmin(String id) {
        try {
                String sql = "Select * from PharmaceuticalAdmin where id = ?";
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
                    PharmaceuticalAdmin p = new PharmaceuticalAdmin(ide, name,emaile,password);
                    return p;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
}

