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
import model.Laboratory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

/**
 *
 * @author madhav
 */
public class LaboratoryService {
     Connection conn;

    public LaboratoryService() {
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
    
    public ArrayList<Laboratory> getAllLaboratorys() {
        ArrayList<Laboratory> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM Laboratory";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                String hospital_id = result.getString("hospital_id");
                Laboratory h = new Laboratory(id,name, hospital_id);
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(Laboratory h) {
        return this.insertLaboratory(h.getName(), h.getId(), h.getHospital_id());
    }
    public String insertLaboratory(String name,String id,String hospital_id) {
        try {
                String sql = "INSERT INTO Laboratory (name, id, hospital_id) VALUES (?, ?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                statement.setString(3, hospital_id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new Laboratory was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(Laboratory h) {
        return this.updateLaboratory(h.getName(), h.getId(),h.getHospital_id());
    }
    public String updateLaboratory(String name,String id, String hospital_id) {
        try {
                String sql = "Update Laboratory set name = ?, hospital_id=? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(3, id);
                statement.setString(2, hospital_id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Laboratory was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteLaboratory(String id) {
        try {
                String sql = "Delete from Laboratory where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Laboratory was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }

    public Laboratory getLaboratory(String LaboratoryId) {
        try {
                String sql = "Select * from Laboratory where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, LaboratoryId);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String id = result.getString("id");
                    String hospital_id = result.getString("hospital_id");
                    Laboratory h = new Laboratory(id,name, hospital_id);            
                    return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public ArrayList<Laboratory> getLabsInHospital(String hid) {
                ArrayList<Laboratory> al = new ArrayList<>();

        try {
                String sql = "Select * from Laboratory where hospital_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, hid);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String id = result.getString("id");
                    String hospital_id = result.getString("hospital_id");
                    Laboratory h = new Laboratory(id,name, hospital_id);            
                    al.add(h);
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
}
