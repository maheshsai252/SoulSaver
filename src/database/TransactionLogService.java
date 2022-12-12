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
import model.TransactionLog;

/**
 *
 * @author maheshsai
 */
public class TransactionLogService {
    Connection conn;
     public TransactionLogService() {
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
    
    public ArrayList<TransactionLog> getAllTransactionLogs() {
        ArrayList<TransactionLog> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM TransactionLog";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String userid = result.getString("user_id");
                String id = result.getString("id");
                String iid = result.getString("inventory_item_id");
                String phid = result.getString("pharmacy_id");
                double qty = result.getDouble("quantity");
                double cost = result.getDouble("cost");
                Date date = result.getTimestamp("date");
                TransactionLog e = new TransactionLog(id,iid,phid,qty,userid,cost,date);
                
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String create(TransactionLog e) {
        return this.insertTransactionLog(e.getId(), e.getUser_id(), e.getPharmacy_id(),e.getInventory_item_id(), e.getQuantity(), e.getCost());
    } 
    public String insertTransactionLog(String id, String user_id, String pharmacy_id, String inventory_item_id, double qty, double cost) {
        try {
                String sql = "INSERT INTO TransactionLog (id, user_id, pharmacy_id, inventory_item_id, quantity, cost,date) VALUES (?, ?, ?,?,?,?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
                statement.setString(2, user_id);
                statement.setString(3, pharmacy_id);
                statement.setString(4, inventory_item_id);
                statement.setDouble(5, qty);
                statement.setDouble(6, cost);
                statement.setTimestamp(7, new java.sql.Timestamp(new Date().getTime()));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new transaction was created successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ex.getMessage());
            return ex.getMessage();
        }
       

    }
    
    public String deleteTransactionLog(String id) {
        try {
                String sql = "Delete from TransactionLog where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "TransactionLog was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public TransactionLog getTransactionLog(String eid) {
        try {
                String sql = "Select * from TransactionLog where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, eid);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                   String userid = result.getString("user_id");
                String id = result.getString("id");
                String iid = result.getString("inventory_item_id");
                String phid = result.getString("pharmacy_id");
                double qty = result.getDouble("quantity");
                Date date = result.getDate("date");
                double cost = result.getDouble("cost");
                TransactionLog e = new TransactionLog(id,iid,phid,qty,userid,cost,date);
                
                
                return e;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public ArrayList<TransactionLog> getAllTransactionLogs(String pharmacy_id, Date from, Date to) {
        ArrayList<TransactionLog> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM TransactionLog where date >= ? and date<= ? and pharmacy_id=?";
             
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setTimestamp(1, new java.sql.Timestamp(from.getTime()));
            statement.setTimestamp(2, new java.sql.Timestamp(to.getTime()));
            statement.setString(3, pharmacy_id);

            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String userid = result.getString("user_id");
                String id = result.getString("id");
                String iid = result.getString("inventory_item_id");
                String phid = result.getString("pharmacy_id");
                double qty = result.getDouble("quantity");
                double cost = result.getDouble("cost");
                Date date = result.getTimestamp("date");
                TransactionLog e = new TransactionLog(id,iid,phid,qty,userid,cost,date);
                
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public ArrayList<TransactionLog> getAllTransactionLogsOfPharmacy(String pharmacy_id) {
        ArrayList<TransactionLog> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM TransactionLog where pharmacy_id=?";
             
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pharmacy_id);

            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String userid = result.getString("user_id");
                String id = result.getString("id");
                String iid = result.getString("inventory_item_id");
                String phid = result.getString("pharmacy_id");
                double qty = result.getDouble("quantity");
                double cost = result.getDouble("cost");
                Date date = result.getTimestamp("date");
                TransactionLog e = new TransactionLog(id,iid,phid,qty,userid,cost,date);
                
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public ArrayList<TransactionLog> getAllInventoryTransactionLogs(String inventory_id, Date from, Date to) {
        ArrayList<TransactionLog> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM TransactionLog where date >= ? and date<= ? and inventory_item_id=?";
             
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setTimestamp(1, new java.sql.Timestamp(from.getTime()));
            statement.setTimestamp(2, new java.sql.Timestamp(to.getTime()));
            statement.setString(3, inventory_id);
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String userid = result.getString("user_id");
                String id = result.getString("id");
                String iid = result.getString("inventory_item_id");
                String phid = result.getString("pharmacy_id");
                double qty = result.getDouble("quantity");
                double cost = result.getDouble("cost");
                Date date = result.getTimestamp("date");
                TransactionLog e = new TransactionLog(id,iid,phid,qty,userid,cost,date);
                
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public ArrayList<TransactionLog> getAllTransactionLogs(String pharmacy_id) {
        ArrayList<TransactionLog> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM TransactionLog where pharmacy_id = ?";
             
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pharmacy_id);

            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String userid = result.getString("user_id");
                String id = result.getString("id");
                String iid = result.getString("inventory_item_id");
                String phid = result.getString("pharmacy_id");
                double qty = result.getDouble("quantity");
                double cost = result.getDouble("cost");
                Date date = result.getTimestamp("date");
                TransactionLog e = new TransactionLog(id,iid,phid,qty,userid,cost,date);
                
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public ArrayList<TransactionLog> getAllInventoryTransactionLogsofInventory(String inventory_id,Date from, Date to) {
        ArrayList<TransactionLog> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM TransactionLog where date >= ? and date<= ? and inventory_item_id=?";
             
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setTimestamp(1, new java.sql.Timestamp(from.getTime()));
            statement.setTimestamp(2, new java.sql.Timestamp(to.getTime()));
            statement.setString(3, inventory_id);
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String userid = result.getString("user_id");
                String id = result.getString("id");
                String iid = result.getString("inventory_item_id");
                String phid = result.getString("pharmacy_id");
                double qty = result.getDouble("quantity");
                double cost = result.getDouble("cost");
                Date date = result.getTimestamp("date");
                TransactionLog e = new TransactionLog(id,iid,phid,qty,userid,cost,date);
                
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public ArrayList<TransactionLog> getAllInventoryTransactionLogsofInventory(String inventory_id) {
        ArrayList<TransactionLog> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM TransactionLog where inventory_item_id=?";
             
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, inventory_id);
            ResultSet result = statement.executeQuery();
            int count = 0;
 
            while (result.next()){
                String userid = result.getString("user_id");
                String id = result.getString("id");
                String iid = result.getString("inventory_item_id");
                String phid = result.getString("pharmacy_id");
                double qty = result.getDouble("quantity");
                double cost = result.getDouble("cost");
                Date date = result.getTimestamp("date");
                TransactionLog e = new TransactionLog(id,iid,phid,qty,userid,cost,date);
                
                al.add(e);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
}
