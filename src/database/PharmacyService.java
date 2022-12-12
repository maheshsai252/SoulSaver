/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author maheshsai
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pharmacy;


/**
 *
 * @author maheshsai
 */
public class PharmacyService {
    Connection conn;

    public PharmacyService() {
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
    
    public ArrayList<Pharmacy> getAllPharmacys() {
        ArrayList<Pharmacy> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM Pharmacy";
             if(conn==null || conn.isClosed()) {
                 fetch();
             }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
 
            while (result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                String email = result.getString("email");
                String address = result.getString("address");
                String pharmaceutical_id = result.getString("pharmaceutical_id");

                Pharmacy h = new Pharmacy(id,address,email,name, pharmaceutical_id);

                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String insert(Pharmacy p) {
        return this.insertPharmacy(p.getName(), p.getId(), p.getEmail(), p.getAddress(), p.getPharmaceutical_id());
    }
    public String insertPharmacy(String name,String id, String email,String address,String pharmaceutical_id) {
        try {
                String sql = "INSERT INTO Pharmacy (name, id, email, address, pharmaceutical_id) VALUES (?, ?, ?,?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                statement.setString(3, email);
                statement.setString(4, address);
                statement.setString(5, pharmaceutical_id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new pharmacy was created successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(Pharmacy p) {
        return this.updatePharmacy(p.getName(),p.getId() , p.getAddress(), p.getEmail(), p.getPharmaceutical_id());
    }
    public String updatePharmacy(String name,String id,String address, String email, String pharmaceutical_id) {
        try {
                String sql = "Update Pharmacy set name = ?, address = ?, email =?,pharmaceutical_id=? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(5, id);
                statement.setString(2, address);
                statement.setString(3, email);
                statement.setString(4, pharmaceutical_id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Pharmacy was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deletePharmacy(String id) {
        try {
                String sql = "Delete from Pharmacy where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Pharmacy was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public Pharmacy getPharmacy(String id) {
        try {
                String sql = "Select * from Pharmacy where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String emaile = result.getString("email");
                    String address = result.getString("address");
                    String ide = result.getString("id");
                    String pharmaceutical_id = result.getString("pharmaceutical_id");
                    Pharmacy p = new Pharmacy(ide, address,emaile,name, pharmaceutical_id);
                    
                    return p;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public ArrayList<Pharmacy> getPharmaciesofpharmaceutical(String id) {
        ArrayList<Pharmacy> al = new ArrayList<>();
        try {
                String sql = "Select * from Pharmacy where pharmaceutical_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String emaile = result.getString("email");
                    String address = result.getString("address");
                    String ide = result.getString("id");
                    String pharmaceutical_id = result.getString("pharmaceutical_id");
                    Pharmacy p = new Pharmacy(ide, address,emaile,name, pharmaceutical_id);
                    
                    al.add(p);
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
    
}

