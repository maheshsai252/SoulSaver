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
import java.util.Date;
import model.EventParticipation;

/**
 *
 * @author somes
 */


public class EventParticipationService {
    Connection conn;
     public EventParticipationService() {
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
    
    public ArrayList<EventParticipation> getAllEventParticipations() {
        ArrayList<EventParticipation> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM EventParticipation";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String eid = result.getString("event_id");
                String id = result.getString("id");
                String uid = result.getString("user_id");
                
                
                EventParticipation e = new EventParticipation(id,eid,uid);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(EventParticipation e) {
        return this.insertEventParticipation(e.getEvent_id(), e.getId(), e.getUser_id());
    } 
    public String insertEventParticipation(String eid,String id, String uid) {
        try {
                String sql = "INSERT INTO EventParticipation (id, event_id, user_id) VALUES (?, ?, ?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
                statement.setString(2, eid);
                statement.setString(3, uid);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new encounter was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
   
    public String deleteEventParticipation(String id) {
        try {
                String sql = "Delete from EventParticipation where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "EventParticipation was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public EventParticipation getEventParticipation(String id) {
        try {
                String sql = "Select * from EventParticipation where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    
                String eid = result.getString("event_id");
                String uid = result.getString("user_id");
                
                
                EventParticipation e = new EventParticipation(id,eid,uid);
                
                return e;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
     public ArrayList<EventParticipation> getAllEventParticipationsOfEvent(String eid) {
        ArrayList<EventParticipation> al = new ArrayList<>();
        try {
            String sql = "Select * from EventParticipation where event_id= ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
               statement.setString(1, eid);
               
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String id = result.getString("id");
                String uid = result.getString("user_id");
                
                
                EventParticipation e = new EventParticipation(id,eid,uid);
                
                al.add(e);
                System.out.println(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
     public ArrayList<EventParticipation> getAllEventParticipationsOfUser(String uid) {
        ArrayList<EventParticipation> al = new ArrayList<>();
        try {
            String sql = "Select * from EventParticipation where user_id= ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
               statement.setString(1, uid);
               
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String id = result.getString("id");
                String eid = result.getString("event_id");
                
                
                EventParticipation e = new EventParticipation(id,eid,uid);
                
                al.add(e);
                System.out.println(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;
       

    }
    
}
