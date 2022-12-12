/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import model.Encounter;

/**
 *
 * @author somes
 */
public class EncounterService {
    Connection conn;
     public EncounterService() {
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
    
    public ArrayList<Encounter> getAllEncounters() {
        ArrayList<Encounter> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM Encounter";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String pid = result.getString("patientid");
                String id = result.getString("id");
                String did = result.getString("doctorid");
                Date date = result.getTimestamp("date");
                String vid = result.getString("vitalid");
                String diagnosis = result.getString("diagnosis");
                double charges = result.getDouble("charges");
                String type = result.getString("type");
                Encounter e = new Encounter(id,vid,pid,did,date,diagnosis,type,charges);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(Encounter e) {
        return this.insertEncounter(e.getPatientId(), e.getId(), e.getDoctorId(), e.getVitalSignsId(), e.getEncounteredTime(),e.getDiagnosis(),e.getType(), e.getCharges());
    } 
    public String insertEncounter(String pid,String id, String did,String vid, Date date1, String diagnosis, String type, double charges) {
        try {
                String sql = "INSERT INTO Encounter (id, patientid, doctorid,vitalid,date, diagnosis, type, charges) VALUES (?, ?, ?,?,?,?,?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
                statement.setString(2, pid);
                statement.setString(3, did);
                statement.setString(4, vid);
                statement.setTimestamp(5, new java.sql.Timestamp(date1.getTime()));
                statement.setString(6, diagnosis);
                statement.setString(7, type);
                statement.setDouble(8, charges);
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
    public String update(Encounter e) {
        return this.updateEncounter(e.getPatientId(), e.getId(), e.getDoctorId(), e.getVitalSignsId(), (Date) e.getEncounteredTime(),e.getDiagnosis(),e.getType(),e.getCharges());
    }
    public String updateEncounter(String pid,String id, String did,String vid, Date date, String diagnosis, String type,double charges) {
        try {
                String sql = "Update Encounter set patientid= ?, doctorid= ?,vitalid= ?,date= ?, diagnosis= ?,type=?,charges=? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(8, id);
                statement.setString(1, pid);
                statement.setString(2, did);
                statement.setString(3, vid);
                statement.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
                statement.setString(5, diagnosis);
                statement.setString(6, type);
                statement.setDouble(7, charges);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Encounter was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteEncounter(String id) {
        try {
                String sql = "Delete from Encounter where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Encounter was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public Encounter getEncounter(String eid) {
        try {
                String sql = "Select * from Encounter where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, eid);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String pid = result.getString("patientid");
                String id = result.getString("id");
                String did = result.getString("doctorid");
                Date date = result.getTimestamp("date");
                String vid = result.getString("vitalid");
                String diagnosis = result.getString("diagnosis");
                double charges = result.getDouble("charges");
                String type = result.getString("type");
                Encounter e = new Encounter(id,vid,pid,did,date,diagnosis,type,charges);
                
                return e;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
     public ArrayList<Encounter> getAllEncountersOfHospital(String hid, Date from, Date to) {
        ArrayList<Encounter> al = new ArrayList<>();
        try {
            String sql = "Select * from Encounter where date>= ? and date<= ? and hospital_id=?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setDate(1, new java.sql.Date(from.getTime()));
                statement.setDate(2, new java.sql.Date(to.getTime()));
               statement.setString(3, hid);
               
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String pid = result.getString("patientid");
                String id = result.getString("id");
                String did = result.getString("doctorid");
                Date date = result.getTimestamp("date");
                String vid = result.getString("vitalid");
                String diagnosis = result.getString("diagnosis");

                 double charges = result.getDouble("charges");
                String type = result.getString("type");
                Encounter e = new Encounter(id,vid,pid,did,date,diagnosis,type,charges);
                al.add(e);
                System.out.println(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
     public ArrayList<Encounter> getAllEncounters(Date from, Date to) {
        ArrayList<Encounter> al = new ArrayList<>();
        try {
            String sql = "Select * from Encounter where date>= ? and date<= ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setDate(1, new java.sql.Date(from.getTime()));
                statement.setDate(2, new java.sql.Date(to.getTime()));
               
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String pid = result.getString("patientid");
                String id = result.getString("id");
                String did = result.getString("doctorid");
                Date date = result.getTimestamp("date");
                String vid = result.getString("vitalid");
                String diagnosis = result.getString("diagnosis");

                 double charges = result.getDouble("charges");
                String type = result.getString("type");
                Encounter e = new Encounter(id,vid,pid,did,date,diagnosis,type,charges);
                al.add(e);
                System.out.println(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
     public ArrayList<Encounter> getAllEncountersOfPatient(String paid) {
        ArrayList<Encounter> al = new ArrayList<>();
        try {
            String sql = "Select * from Encounter where patientid = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, paid);
 
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String pid = result.getString("patientid");
                String id = result.getString("id");
                String did = result.getString("doctorid");
                Date date = result.getTimestamp("date");
                String vid = result.getString("vitalid");
                String diagnosis = result.getString("diagnosis");

                 double charges = result.getDouble("charges");
                String type = result.getString("type");
                Encounter e = new Encounter(id,vid,pid,did,date,diagnosis,type,charges);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public ArrayList<Encounter> getAllEncountersOfDoctor(String daid) {
        ArrayList<Encounter> al = new ArrayList<>();
        try {
            String sql = "Select * from Encounter where doctorid = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, daid);
 
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String pid = result.getString("patientid");
                String id = result.getString("id");
                String did = result.getString("doctorid");
                Date date = result.getTimestamp("date");
                String vid = result.getString("vitalid");
                String diagnosis = result.getString("diagnosis");

                double charges = result.getDouble("charges");
                String type = result.getString("type");
                Encounter e = new Encounter(id,vid,pid,did,date,diagnosis,type,charges);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    
    
}
