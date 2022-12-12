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
import model.LabAdmin;
import model.Patient;

/**
 *
 * @author madhav
 */
public class LabAdminService {
     Connection conn;

    public LabAdminService() {
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
    
    public ArrayList<LabAdmin> getAllLabAdmins() {
        ArrayList<LabAdmin> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM LabAdmin";
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
                LabAdmin h = new LabAdmin(id,name,email,password);
                h.setLaboratory_id(result.getString("laboratory_id"));

                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String insert(LabAdmin p) {
        return this.insertLabAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
    }
    public String insertLabAdmin(String name,String id, String email,String password) {
        try {
                String sql = "INSERT INTO LabAdmin (name, id, email, password) VALUES (?, ?, ?,?)";
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
    public String update(LabAdmin p) {
        return this.updateLabAdmin(p.getName(),p.getId() , p.getPassword(), p.getLaboratory_id());
    }
    public String updateLabAdmin(String name,String id,String password,String laboratory_id) {
        try {
                String sql = "Update LabAdmin set name = ?, password = ?, laboratory_id=? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(4, id);
                statement.setString(2, password);
                
                statement.setString(3, laboratory_id);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "LabAdmin was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! " + ex.getMessage());
            return ex.getMessage();
        }
       

    }
    public String deleteLabAdmin(String id) {
        try {
                String sql = "Delete from LabAdmin where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "LabAdmin was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public LabAdmin getLabAdmin(String id) {
        try {
                String sql = "Select * from LabAdmin where id = ?";
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
                    LabAdmin p = new LabAdmin(ide, name,emaile,password);
                    p.setLaboratory_id(result.getString("laboratory_id"));

                    return p;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public ArrayList<LabAdmin> getLabAdminsInOrg(String id) {
        ArrayList<LabAdmin> al = new ArrayList<>();
        try {
                String sql = "Select * from LabAdmin where laboratory_id = ?";
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
                    LabAdmin p = new LabAdmin(ide, name,emaile,password);
                    p.setLaboratory_id(result.getString("laboratory_id"));

                    al.add(p);
                    
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
}
