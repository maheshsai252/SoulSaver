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
import model.Event;

/**
 *
 * @author somes
 */
public class EventService {
     Connection conn;

    public EventService() {
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
    
    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM Event";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                Date date = result.getDate("date");
                String hid = result.getString("hospitalId");
                Event h = new Event(id,name,date,hid);

                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String insert(Event p) {
        return this.insertEvent(p.getName(), p.getId(), p.getDate(), p.getHospitalId());
    }
    public String insertEvent(String name,String id, Date date,String hid) {
        try {
                String sql = "INSERT INTO Event (name, id, date, hospitalId) VALUES (?, ?, ?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                statement.setDate(3, new java.sql.Date(date.getTime()));
                statement.setString(4, hid);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new event was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return ex.getMessage();
        }
       

    }
    public String update(Event p) {
        return this.updateEvent(p.getName(),p.getId() , p.getDate(), p.getHospitalId());
    }
    public String updateEvent(String name,String id,Date date,String hid) {
        try {
            System.out.println("updating "+ hid);
                String sql = "Update Event set name = ?, date = ?, hospitalId=? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(4, id);
                statement.setDate(2, new java.sql.Date(date.getTime()));
                statement.setString(3, hid);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "event was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! " + ex.getMessage());
            return ex.getMessage();
        }
       

    }
    public String deleteEvent(String id) {
        try {
                String sql = "Delete from event where id = ?";
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
    public Event getEvent(String id) {
        try {
                String sql = "Select * from event where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                     String name = result.getString("name");
                Date date = result.getDate("date");
                String hid = result.getString("hospitalId");
                Event h = new Event(id,name,date,hid);
                return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public ArrayList<Event> getAllEventsOfHospital(String hid) {
        ArrayList<Event> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM Event where hospitalId = ? ";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, hid);
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                Date date = result.getDate("date");
                Event h = new Event(id,name,date,hid);

                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
}
