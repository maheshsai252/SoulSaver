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
import model.InventoryItem;

/**
 *
 * @author madhav
 */
public class InventoryItemService {
    Connection conn;
     public InventoryItemService() {
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
    
    public ArrayList<InventoryItem> getAllInventoryItems() {
        ArrayList<InventoryItem> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM InventoryItem";
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
                double cost = result.getDouble("cost");
                InventoryItem e = new InventoryItem(id,name,qty,cost,mid,pid);
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(InventoryItem e) {
        return this.insertInventoryItem(e.getName(), e.getId(), e.getQty(),e.getCost(), e.getManufacturer_id(), e.getPharmacy_id());
    } 
    public String insertInventoryItem(String name,String id, int qty,double cost, String mid,String pid) {
        try {
                String sql = "INSERT INTO InventoryItem (id, name, quantity, manufacturer_id, pharmacy_id,cost) VALUES (?, ?, ?,?,?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
                statement.setString(2, name);
                statement.setInt(3, qty);
                statement.setString(4, mid);
                statement.setString(5, pid);
                statement.setDouble(6,cost);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new inventory item was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(InventoryItem e) {
        return this.updateInventoryItem(e.getName(), e.getId(), e.getQty(),e.getCost(),  e.getManufacturer_id(), e.getPharmacy_id());
    }
    public String updateInventoryItem(String name,String id, int qty,double cost,String mid,String pid) {
        try {
                String sql = "Update InventoryItem set name= ?, quantity= ?,manufacturer_id= ?,pharmacy_id= ?, cost =?  where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(6, id);
                statement.setString(1, name);
                statement.setInt(2, qty);
                statement.setString(3, mid);
                statement.setString(4, pid);
                statement.setDouble(5, cost);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "InventoryItem was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteInventoryItem(String id) {
        try {
                String sql = "Delete from InventoryItem where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "InventoryItem was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public InventoryItem getInventoryItem(String eid) {
        try {
                String sql = "Select * from InventoryItem where id = ?";
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

                double cost = result.getDouble("cost");
                InventoryItem e = new InventoryItem(id,name,qty,cost,mid,pid);       
                return e;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public ArrayList<InventoryItem> getAllInventoryItemsOfManufacturer(String paid) {
        ArrayList<InventoryItem> al = new ArrayList<>();
        try {
            String sql = "Select * from InventoryItem where manufacturer_id = ?";
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

                double cost = result.getDouble("cost");
                InventoryItem e = new InventoryItem(id,name,qty,cost,mid,pid);                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public ArrayList<InventoryItem> getAllInventoryItemsOfPharmacy(String daid) {
        ArrayList<InventoryItem> al = new ArrayList<>();
        try {
            System.out.println(daid+" test1 ");
            String sql = "Select * from InventoryItem where pharmacy_id = ?";
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

                double cost = result.getDouble("cost");
                InventoryItem e = new InventoryItem(id,name,qty,cost,mid,pid);                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
}
