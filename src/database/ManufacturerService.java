package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Manufacturer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maheshsai
 */
public class ManufacturerService {
    Connection conn;

    public ManufacturerService() {
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
    
    public ArrayList<Manufacturer> getAllManufacturers() {
        ArrayList<Manufacturer> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM Manufacturer";
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
                String password = result.getString("password");
                String manufacturingdepartment_id = result.getString("manufacturingdepartment_id");
               Manufacturer p = new Manufacturer(id,address,email,name,password);
               p.setManufacturingdepartment_id(manufacturingdepartment_id);
                al.add(p);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String insert(Manufacturer p) {
        return this.insertManufacturer(p.getName(), p.getId(), p.getEmail(), p.getPassword());
    }
    public String insertManufacturer(String name,String id, String email,String password) {
        try {
                String sql = "INSERT INTO Manufacturer (name, id, email, password) VALUES (?, ?, ?,?)";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, id);
                statement.setString(3, email);
                statement.setString(4, password);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "A new erson was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(Manufacturer p) {
        return this.updateManufacturer(p.getName(),p.getId() , p.getEmail(), p.getAddress(), p.getPassword(), p.getManufacturingdepartment_id());
    }
    public String updateManufacturer(String name,String id,String address, String email, String password, String manufacturingdepartment_id) {
        try {
                String sql = "Update Manufacturer set name = ?, address = ?, email =?, password=?, manufacturingdepartment_id =? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(6, id);
                statement.setString(2, address);
                statement.setString(3, email);
                statement.setString(4, password);
                statement.setString(5, manufacturingdepartment_id);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Manufacturer was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String deleteManufacturer(String id) {
        try {
                String sql = "Delete from Manufacturer where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "Manufacturer was deleted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }

    }
    public Manufacturer getManufacturer(String id) {
        try {
                String sql = "Select * from Manufacturer where id = ?";
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
                    String password = result.getString("password");
                    String ide = result.getString("id");
                    String manufacturingdepartment_id = result.getString("manufacturingdepartment_id");
                    Manufacturer p = new Manufacturer(ide,address,emaile,name,password);
                    p.setManufacturingdepartment_id(manufacturingdepartment_id);
                    return p;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
     public ArrayList<Manufacturer> getManufacturersOfDept(String id) {
                 ArrayList<Manufacturer> al = new ArrayList<>();

        try {
                String sql = "Select * from Manufacturer where manufacturingdepartment_id = ?";
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
                    String password = result.getString("password");
                    String ide = result.getString("id");
                    String manufacturingdepartment_id = result.getString("manufacturingdepartment_id");
                    Manufacturer p = new Manufacturer(ide,address,emaile,name,password);
                    p.setManufacturingdepartment_id(manufacturingdepartment_id);
                    al.add(p);
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
}
