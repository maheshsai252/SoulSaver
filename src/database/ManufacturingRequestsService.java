
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
import model.ManufacturingRequests;

/**
 *
 * @author maheshsai
 */
public class ManufacturingRequestsService {
    Connection conn;
     public ManufacturingRequestsService() {
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
    
    public ArrayList<ManufacturingRequests> getAllManufacturingRequestss() {
        ArrayList<ManufacturingRequests> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM ManufacturingRequests";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                int qty = result.getInt("quantity");
                String mid = result.getString("manufacturer_id");
                String pid = result.getString("pharmacy_id");
                String iid = result.getString("inventory_item_id");

                ManufacturingRequests e = new ManufacturingRequests(id,name,qty,mid,pid,iid);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(ManufacturingRequests e) {
        return this.insertManufacturingRequests(e.getName(), e.getId(), e.getQty(), e.getManufacturer_id(), e.getPharmacy_id(), e.getInventory_item_id());
    } 
    public String insertManufacturingRequests(String name,String id, int qty,String mid,String pid, String iid) {
        try {
                String sql = "INSERT INTO ManufacturingRequests (id, name, quantity, manufacturer_id, pharmacy_id, inventory_item_id) VALUES (?, ?, ?,?,?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
                statement.setString(2, name);
                statement.setInt(3, qty);
                statement.setString(4, mid);
                statement.setString(5, pid);
                statement.setString(6, iid);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new request was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(ManufacturingRequests e) {
        return this.updateManufacturingRequests(e.getName(), e.getId(), e.getQty(), e.getManufacturer_id(), e.getPharmacy_id(), e.getInventory_item_id());
    }
    public String updateManufacturingRequests(String name,String id, int qty,String mid,String pid, String iid) {
        try {
                String sql = "Update ManufacturingRequests set name= ?, quantity= ?,manufacturer_id= ?,pharmacy_id= ?, inventory_item_id =? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(6, id);
                statement.setString(1, name);
                statement.setInt(2, qty);
                statement.setString(3, mid);
                statement.setString(4, pid);
                statement.setString(5, iid);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Manufacturing Request was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteManufacturingRequests(String id) {
        try {
                String sql = "Delete from ManufacturingRequests where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "ManufacturingRequest was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public ManufacturingRequests getManufacturingRequests(String eid) {
        try {
                String sql = "Select * from ManufacturingRequests where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, eid);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                     String name = result.getString("name");
                String id = result.getString("id");
                int qty = result.getInt("quantity");
                String mid = result.getString("manufacturer_id");
                String pid = result.getString("pharmacy_id");
                String iid = result.getString("inventory_item_id");


                ManufacturingRequests e = new ManufacturingRequests(id,name,qty,mid,pid,iid);
                return e;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public ArrayList<ManufacturingRequests> getAllManufacturingRequestssOfManufacturer(String paid) {
        ArrayList<ManufacturingRequests> al = new ArrayList<>();
        try {
            String sql = "Select * from ManufacturingRequests where manufacturer_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, paid);
 
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                 String name = result.getString("name");
                String id = result.getString("id");
                int qty = result.getInt("quantity");
                String mid = result.getString("manufacturer_id");
                String pid = result.getString("pharmacy_id");
                String iid = result.getString("inventory_item_id");

                ManufacturingRequests e = new ManufacturingRequests(id,name,qty,mid,pid,iid);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public ArrayList<ManufacturingRequests> getAllManufacturingRequestssOfPharmacy(String daid) {
        ArrayList<ManufacturingRequests> al = new ArrayList<>();
        try {
            String sql = "Select * from ManufacturingRequests where pharmacy_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, daid);
 
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                int qty = result.getInt("quantity");
                String mid = result.getString("manufacturer_id");
                String pid = result.getString("pharmacy_id");
                String iid = result.getString("inventory_item_id");

                ManufacturingRequests e = new ManufacturingRequests(id,name,qty,mid,pid,iid);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public ArrayList<ManufacturingRequests> getAllManufacturingRequestssOfInventoryItem(String daid) {
        ArrayList<ManufacturingRequests> al = new ArrayList<>();
        try {
            String sql = "Select * from ManufacturingRequests where inventory_item_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, daid);
 
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                int qty = result.getInt("quantity");
                String mid = result.getString("manufacturer_id");
                String pid = result.getString("pharmacy_id");
                String iid = result.getString("inventory_item_id");

                ManufacturingRequests e = new ManufacturingRequests(id,name,qty,mid,pid,iid);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
}
