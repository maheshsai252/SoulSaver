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
import model.Doctor;
import model.Patient;

/**
 *
 * @author somes
 */
public class DoctorService {
     Connection conn;

    public DoctorService() {
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
    
    public ArrayList<Doctor> getAllDoctors() {
        ArrayList<Doctor> al = new ArrayList<>();
        try {
             String sql = "SELECT * FROM Doctor";
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
                String password = result.getString("password");
                Doctor h = new Doctor(id,name,email,password);
                h.setHospitalId(result.getString("hospitalid"));
                h.setDoctororg_id(result.getString("doctororg_id"));
                 h.setConsultation_charges(result.getDouble("consultation_charges"));
                    h.setSurgery_charges(result.getDouble("surgery_charges"));

                al.add(h);
            }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            System.out.println(ex.getMessage());
        }
       
        return al;

    }
    public String insert(Doctor p) {
        return this.insertDoctor(p.getName(), p.getId(), p.getEmail(), p.getPassword());
    }
    public String insertDoctor(String name,String id, String email,String password) {
        try {
                String sql = "INSERT INTO Doctor (name, id, email, password) VALUES (?, ?, ?,?)";
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
                   return "A new person was inserted successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! ");
            return ex.getMessage();
        }
       

    }
    public String update(Doctor p) {
        return this.updateDoctor(p.getName(),p.getId() , p.getPassword(), p.getDoctororg_id(), p.getHospitalId(),p.getConsultation_charges(),p.getSurgery_charges());
    }
    public String updateDoctor(String name,String id,String password,String doctororg_id, String hid, double cc, double sc) {
        try {
            System.out.println("updating "+ hid);
                String sql = "Update Doctor set name = ?, password = ?, hospitalid=?, consultation_charges=?, surgery_charges=?, doctororg_id=? where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(7, id);
                statement.setString(2, password);
                statement.setString(3, hid);
                statement.setDouble(4, cc);
                statement.setDouble(5, sc);
                statement.setString(6, doctororg_id);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return "doctor was updated successfully!";
                }  else {
                    return "got error";
                }
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! " + ex.getMessage());
            return ex.getMessage();
        }
       

    }
    public String deleteDoctor(String id) {
        try {
                String sql = "Delete from doctor where id = ?";
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
    public Doctor getDoctor(String id) {
        try {
                String sql = "Select * from doctor where id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String emaile = result.getString("email");
                    String password = result.getString("password");
                    String ide = result.getString("id");
                    Doctor p = new Doctor(ide, name,emaile,password);
                    p.setHospitalId(result.getString("hospitalid"));
                    p.setDoctororg_id(result.getString("doctororg_id"));

                    p.setConsultation_charges(result.getDouble("consultation_charges"));
                    p.setSurgery_charges(result.getDouble("surgery_charges"));

                    return p;
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return null;
    }
    public ArrayList<Doctor> getDoctorsInOrg(String id) {
        ArrayList<Doctor> al = new ArrayList<>();
        try {
                String sql = "Select * from doctor where doctororg_id = ?";
                if(conn==null || conn.isClosed()) {
                    fetch();
                }
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
 
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    String name = result.getString("name");
                    String emaile = result.getString("email");
                    String password = result.getString("password");
                    String ide = result.getString("id");
                    Doctor p = new Doctor(ide, name,emaile,password);
                    p.setHospitalId(result.getString("hospitalid"));
                    p.setDoctororg_id(result.getString("doctororg_id"));

                    p.setConsultation_charges(result.getDouble("consultation_charges"));
                    p.setSurgery_charges(result.getDouble("surgery_charges"));
                    al.add(p);
                    
                }
                
        } catch (SQLException ex) { 
            System.out.println("Connect failed ! "+ ex.getMessage());
            return null;
        }
        return al;
    }
}
