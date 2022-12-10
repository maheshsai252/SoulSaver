package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.ForecastOrg;
import model.ForecastOrg;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maheshsai
 */
public class ForecastOrgService {
     Connection conn;

    public ForecastOrgService() {
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
    
    public ArrayList<ForecastOrg> getAllForecastOrgs() {
        ArrayList<ForecastOrg> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM ForecastOrg";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                String planningep_id = result.getString("planningep_id");

                ForecastOrg h = new ForecastOrg(id,name, planningep_id);

                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String insert(ForecastOrg p) {
        return this.insertForecastOrg(p.getName(), p.getId(), p.getPlanningep_id());
    }
    public String insertForecastOrg(String name,String id, String planningep_id) {
        try {
                String sql = "INSERT INTO ForecastOrg (name, id, planningep_id) VALUES (?, ?, ?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
               statement.setString(3, planningep_id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new ForecastOrg was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return ex.getMessage();
        }
       

    }
    public String update(ForecastOrg p) {
        return this.updateForecastOrg(p.getName(),p.getId(), p.getPlanningep_id());
    }
    public String updateForecastOrg(String name,String id, String planningep_id) {
        try {
            System.out.println("updating "+ id);
                String sql = "Update ForecastOrg set name = ?, planningep_id = ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(3, id);
                statement.setString(2, planningep_id);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ForecastOrg was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! " + ex.getMessage());
            return ex.getMessage();
        }
       

    }
    public String deleteForecastOrg(String id) {
        try {
                String sql = "Delete from ForecastOrg where id = ?";
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
    public ForecastOrg getForecastOrg(String id) {
        try {
                String sql = "Select * from ForecastOrg where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                     String name = result.getString("name");
                     String planningep_id = result.getString("planningep_id");
                ForecastOrg h = new ForecastOrg(id,name, planningep_id);
                return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public ArrayList<ForecastOrg> getForecastOrgofplanningenterprise(String rid) {
         ArrayList<ForecastOrg> al = new ArrayList<>();
        try {
                String sql = "Select * from ForecastOrg where planningep_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, rid);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                     String name = result.getString("name");
                     String id = result.getString("id");
                     String planningep_id = result.getString("planningep_id");
                    ForecastOrg h = new ForecastOrg(id,name,planningep_id);
                    al.add(h);
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
   
}
