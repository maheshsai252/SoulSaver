/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import Services.FetchGeoService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import model.Hospital;
import model.Person;

/**
 *
 * @author madhav
 */
public class HospitalDBService {
    Connection conn;

    public HospitalDBService() {
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
    
    public ArrayList<Hospital> getAllHospitals() {
        ArrayList<Hospital> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM Hospital";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                String address = result.getString("address");
                Hospital h = new Hospital(name,id,address);
                Double lat = result.getDouble("lat");
                Double lng = result.getDouble("lng");
                h.setLat(lat);
h.setLng(lng);
                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(Hospital h) {
        return this.insertHospital(h.getName(), h.getId(), h.getAddress());
    }
    public String insertHospital(String name,String id,String address) {
        try {
                String sql = "INSERT INTO Hospital (name, id, address, lat, lng) VALUES (?, ?, ?, ? , ?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                statement.setString(3, address);
                 String response = FetchGeoService.getLocation(address);
        System.out.println(response);
//
        String[] result = FetchGeoService.parseLocation(response);
                if(result.length >=2) {
                statement.setDouble(4, Double.parseDouble(result[0]));
                statement.setDouble(5, Double.parseDouble(result[1]));
                } else {
                    statement.setDouble(4, 0);
                    statement.setDouble(5, 0);
                }
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new hospital was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(Hospital h) {
        return this.updateHospital(h.getName(), h.getId(), h.getAddress());
    }
    public String updateHospital(String name,String id,String address) {
        try {
                String sql = "Update Hospital set name = ?, address = ?, lat=?,lng=? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(5, id);
                statement.setString(2, address);
 String response = FetchGeoService.getLocation(address);
        System.out.println(response);
//
        String[] result = FetchGeoService.parseLocation(response);
                if(result.length >=2) {
                statement.setDouble(3, Double.parseDouble(result[0]));
                statement.setDouble(4, Double.parseDouble(result[1]));
                } else {
                    statement.setDouble(3, 0);
                    statement.setDouble(4, 0);
                }
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "hospital was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteHospital(String id) {
        try {
                String sql = "Delete from hospital where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "hospital was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }

    public Hospital getHospital(String hospitalId) {
        try {
                String sql = "Select * from hospital where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, hospitalId);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String id = result.getString("id");
                    String address = result.getString("address");
                    Hospital hospital = new Hospital(name,id,address);
                     Double lat = result.getDouble("lat");
                    Double lng = result.getDouble("lng");
                    hospital.setLat(lat);
                    hospital.setLng(lng);
                    return hospital;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    
}
