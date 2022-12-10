/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author somes
 */
public class Doctor {
     private String docID;
    private String docName;
    private String hospID;
    private String docUsername;
    private String docPass;

    public Doctor(String docID, String docName, String hospID) {
        this.docID = docID;
        this.docName = docName;
        this.hospID = hospID;
    }

    public String getDocUsername() {
        return docUsername;
    }

    public void setDocUsername(String docUsername) {
        this.docUsername = docUsername;
    }

    public String getDocPass() {
        return docPass;
    }

    public void setDocPass(String docPass) {
        this.docPass = docPass;
    }
    
    public Doctor() {
        this.docID = "123";
        this.docName = "Rahul";
        this.hospID = "3456";
    }
    

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getHospID() {
        return hospID;
    }

    public void setHospID(String hospID) {
        this.hospID = hospID;
    }
    @Override
    public String toString(){
        return docName;
    }
}
