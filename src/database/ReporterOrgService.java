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
import model.ReporterOrg;

/**
 *
 * @author maheshsai
 */
public class ReporterOrgService {
    Connection conn;

    public ReporterOrgService() {
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
    
    public ArrayList<ReporterOrg> getAllReporterOrgs() {
        ArrayList<ReporterOrg> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM ReporterOrg";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
               String revenueep_id = result.getString("revenueep_id");
                ReporterOrg h = new ReporterOrg(id,name);

                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String insert(ReporterOrg p) {
        return this.insertReporterOrg(p.getName(), p.getId(), p.getRevenueep_id());
    }
    public String insertReporterOrg(String name,String id, String revenueep_id) {
        try {
                String sql = "INSERT INTO ReporterOrg (name, id, revenueep_id) VALUES (?, ?, ?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
               statement.setString(3, revenueep_id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new ReporterOrg was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return ex.getMessage();
        }
       

    }
    public String update(ReporterOrg p) {
        return this.updateReporterOrg(p.getName(),p.getId(), p.getRevenueep_id());
    }
    public String updateReporterOrg(String name,String id, String revenueep_id) {
        try {
            System.out.println("updating "+ id);
                String sql = "Update ReporterOrg set name = ?, revenueep_id = ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(3, id);
                statement.setString(2, revenueep_id);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ReporterOrg was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! " + ex.getMessage());
            return ex.getMessage();
        }
       

    }
    public String deleteReporterOrg(String id) {
        try {
                String sql = "Delete from ReporterOrg where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "doctor was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public ReporterOrg getReporterOrg(String id) {
        try {
                String sql = "Select * from ReporterOrg where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                     String name = result.getString("name");
                     String revenueep_id = result.getString("revenueep_id");
                ReporterOrg h = new ReporterOrg(id,name,revenueep_id);
                return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
     public ArrayList<ReporterOrg> getReporterOrgofrevenueenterprise(String rid) {
         ArrayList<ReporterOrg> al = new ArrayList<>();
        try {
                String sql = "Select * from ReporterOrg where revenueep_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, rid);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                     String name = result.getString("name");
                     String id = result.getString("id");
                     String revenueep_id = result.getString("revenueep_id");
                    ReporterOrg h = new ReporterOrg(id,name,revenueep_id);
                    al.add(h);
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
}
