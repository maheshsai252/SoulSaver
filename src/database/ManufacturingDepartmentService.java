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
import model.ManufacturingDepartment;

/**
 *
 * @author maheshsai
 */

public class ManufacturingDepartmentService {
     Connection conn;

    public ManufacturingDepartmentService() {
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
    
    public ArrayList<ManufacturingDepartment> getAllManufacturingDepartments() {
        ArrayList<ManufacturingDepartment> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM ManufacturingDepartment";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                String pharmaceutical_id = result.getString("pharmaceutical_id");
                ManufacturingDepartment h = new ManufacturingDepartment(id,name);
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(ManufacturingDepartment h) {
        return this.insertManufacturingDepartment(h.getName(), h.getId(), h.getPharmaceutical_id());
    }
    public String insertManufacturingDepartment(String name,String id,String pharmaceutical_id ) {
        try {
                String sql = "INSERT INTO ManufacturingDepartment (name, id, pharmaceutical_id) VALUES (?, ?, ?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                statement.setString(3, pharmaceutical_id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new ManufacturingDepartment was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(ManufacturingDepartment h) {
        return this.updateManufacturingDepartment(h.getName(), h.getId(), h.getPharmaceutical_id());
    }
    public String updateManufacturingDepartment(String name,String id, String pharmaceutical_id) {
        try {
                String sql = "Update ManufacturingDepartment set name = ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                
                statement.setString(3, pharmaceutical_id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ManufacturingDepartment was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteManufacturingDepartment(String id) {
        try {
                String sql = "Delete from ManufacturingDepartment where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
                 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ManufacturingDepartment was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }

    public ManufacturingDepartment getManufacturingDepartment(String ManufacturingDepartmentId) {
        try {
                String sql = "Select * from ManufacturingDepartment where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, ManufacturingDepartmentId);
                
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String id = result.getString("id");
                    String pharmaceutical_id = result.getString("pharmaceutical_id");
                    ManufacturingDepartment h = new ManufacturingDepartment(id,name, pharmaceutical_id );            
                    return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
     public ArrayList<ManufacturingDepartment> getManufacturingDepartmentsofPharmaceutical(String ManufacturingDepartmentId) {
        ArrayList<ManufacturingDepartment> al = new ArrayList<>();
         
         try {
                String sql = "Select * from ManufacturingDepartment where pharmaceutical_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, ManufacturingDepartmentId);
                
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String id = result.getString("id");
                    String pharmaceutical_id = result.getString("pharmaceutical_id");
                    ManufacturingDepartment h = new ManufacturingDepartment(id,name, pharmaceutical_id );            
                    al.add(h);
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
    
}
