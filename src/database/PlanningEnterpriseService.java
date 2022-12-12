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
import model.PlanningEnterprise;

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
public class PlanningEnterpriseService {
     Connection conn;

    public PlanningEnterpriseService() {
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
    
    public ArrayList<PlanningEnterprise> getAllPlanningEnterprises() {
        ArrayList<PlanningEnterprise> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM PlanningEnterprise";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                PlanningEnterprise h = new PlanningEnterprise(id,name);
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(PlanningEnterprise h) {
        return this.insertPlanningEnterprise(h.getName(), h.getId());
    }
    public String insertPlanningEnterprise(String name,String id ) {
        try {
                String sql = "INSERT INTO PlanningEnterprise (name, id) VALUES (?, ?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new PlanningEnterprise was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(PlanningEnterprise h) {
        return this.updatePlanningEnterprise(h.getName(), h.getId());
    }
    public String updatePlanningEnterprise(String name,String id) {
        try {
                String sql = "Update PlanningEnterprise set name = ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "PlanningEnterprise was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deletePlanningEnterprise(String id) {
        try {
                String sql = "Delete from PlanningEnterprise where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "PlanningEnterprise was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }

    public PlanningEnterprise getPlanningEnterprise(String PlanningEnterpriseId) {
        try {
                String sql = "Select * from PlanningEnterprise where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, PlanningEnterpriseId);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String id = result.getString("id");
                    PlanningEnterprise h = new PlanningEnterprise(id,name);            
                    return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    
}
