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
import model.RevenueEnterprise;

/**
 *
 * @author maheshsai
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

/**
 *
 * @author maheshsai
 */
public class RevenueEnterpriseService {
     Connection conn;

    public RevenueEnterpriseService() {
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
    
    public ArrayList<RevenueEnterprise> getAllRevenueEnterprises() {
        ArrayList<RevenueEnterprise> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM RevenueEnterprise";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                RevenueEnterprise h = new RevenueEnterprise(id,name);
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(RevenueEnterprise h) {
        return this.insertRevenueEnterprise(h.getName(), h.getId());
    }
    public String insertRevenueEnterprise(String name,String id ) {
        try {
                String sql = "INSERT INTO RevenueEnterprise (name, id) VALUES (?, ?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new RevenueEnterprise was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(RevenueEnterprise h) {
        return this.updateRevenueEnterprise(h.getName(), h.getId());
    }
    public String updateRevenueEnterprise(String name,String id) {
        try {
                String sql = "Update RevenueEnterprise set name = ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "RevenueEnterprise was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteRevenueEnterprise(String id) {
        try {
                String sql = "Delete from RevenueEnterprise where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "RevenueEnterprise was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }

    public RevenueEnterprise getRevenueEnterprise(String RevenueEnterpriseId) {
        try {
                String sql = "Select * from RevenueEnterprise where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, RevenueEnterpriseId);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String id = result.getString("id");
                    RevenueEnterprise h = new RevenueEnterprise(id,name);            
                    return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    
}
