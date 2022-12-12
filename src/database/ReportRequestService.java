/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import model.ReportRequest;

/**
 *
 * @author maheshsai
 */
public class ReportRequestService {
     Connection conn;

    public ReportRequestService() {
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
    
    public ArrayList<ReportRequest> getAllReportRequests() {
        ArrayList<ReportRequest> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM ReportRequests";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String hid = result.getString("hospital_id");
                String id = result.getString("id");
                Boolean status = result.getBoolean("status");
                Date date = result.getDate("date");
                ReportRequest h = new ReportRequest(id,hid,status,date);
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(ReportRequest p) {
        return this.insertReportRequest(p.getHid(), p.getId(), p.getStatus(), p.getDate());
    }
    public String insertReportRequest(String hid,String id, Boolean status,Date date) {
        try {
                String sql = "INSERT INTO ReportRequests (hospital_id, id, status,date) VALUES (?, ?, ?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, hid);
                statement.setString(2, id);
                statement.setBoolean(3, status);
                statement.setDate(4, new java.sql.Date(date.getTime()));

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new reporter was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(ReportRequest p) {
        return this.updateReportRequest(p.getHid(), p.getId(), p.getStatus(), p.getDate());
    }
    public String updateReportRequest(String hid,String id, Boolean status,Date date) {
        try {
                String sql = "Update ReportRequests set hospital_id = ?, status = ?, date = ? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, hid);
                statement.setString(4, id);
                statement.setBoolean(2, status);
                statement.setDate(3, new java.sql.Date(date.getTime()));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ReportRequest was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteReportRequest(String id) {
        try {
                String sql = "Delete from ReportRequests where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ReportRequest was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    
    public ReportRequest getReportRequest(String id) {
        try {
                String sql = "Select * from ReportRequests where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                     String hid = result.getString("hospital_id");
                Boolean status = result.getBoolean("status");
                Date date = result.getDate("date");
                ReportRequest h = new ReportRequest(id,hid,status,date);
                    return h;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
     public ArrayList<ReportRequest> getHospitalReportRequests(String id) {
         ArrayList<ReportRequest> al = new ArrayList<>();
        try {
                String sql = "Select * from ReportRequests where hospital_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                HospitalDBService hs = new HospitalDBService();
                
                while(result.next()) {
                    
                    String hid = result.getString("hospital_id");
                Boolean status = result.getBoolean("status");
                Date date = result.getDate("date");
                ReportRequest h = new ReportRequest(id,hid,status,date);
                   al.add(h);
                    
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
      public ArrayList<ReportRequest> getReporterHospitalReportRequests(String rid) {
         ArrayList<ReportRequest> al = new ArrayList<>();
        try {
            ArrayList<String> hsptls = new ReporterAssignmentService().getAllHospitalsofReporter(rid);
            System.out.print(hsptls+"hsptls");
            
            String placeHolders = String.join(",", Collections.nCopies(hsptls.size(), "?"));

            String sql = "select * from ReportRequests where hospital_id in (" + placeHolders + ")";

//                String sql = "Select * from ReportRequests where hospital_id in (?)";
                
//                String sql = String.format("SELECT * FROM ReportRequests WHERE hospital_id IN (%s)",
//    hsptls.stream()
//    .map(String::valueOf)
//    .collect(Collectors.joining(", ")));
                
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
//                Array array = statement.getConnection().createArrayOf("VARCHAR", new Object[]{hsptls.toArray()});
//                statement.setArray(1, array);

        int i = 1;
    for (String param : hsptls) {
        statement.setString(i++, param);
    }
    System.out.println(sql);
 
                ResultSet result = statement.executeQuery();
                
                while(result.next()) {
                    
                String hid = result.getString("hospital_id");
                Boolean status = result.getBoolean("status");
                String id = result.getString("id");
                Date date = result.getDate("date");
                ReportRequest h = new ReportRequest(id,hid,status,date);
                   al.add(h);
                   
                    
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return al;
        }
        return al;
    }
      public ArrayList<ReportRequest> getReporterPharmacyReportRequests(String rid) {
         ArrayList<ReportRequest> al = new ArrayList<>();
        try {
            
            ArrayList<String> hsptls = new ReporterAssignmentService().getAllPharmacysOfReporter(rid);
            System.out.println(hsptls+"hsptls");
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                String placeHolders = String.join(",", Collections.nCopies(hsptls.size(), "?"));

                String sql = "select * from ReportRequests where hospital_id in (" + placeHolders + ")";

                PreparedStatement statement = conn.prepareStatement(sql);
 
                
                int i = 1;
                for (String param : hsptls) {
                       statement.setString(i++, param);
                }   
                                ResultSet result = statement.executeQuery();

                while(result.next()) {
                    
                    String hid = result.getString("hospital_id");
                Boolean status = result.getBoolean("status");
                String id = result.getString("id");
                Date date = result.getDate("date");
                ReportRequest h = new ReportRequest(id,hid,status,date);
                   al.add(h);
                    
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return al;
        }
        return al;
    }
     
}
