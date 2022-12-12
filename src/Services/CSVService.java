/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import database.HospitalDBService;
import database.PharmacyService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hospital;

/**
 *
 * @author maheshsai
 */
public class CSVService {
    HospitalDBService hs = new HospitalDBService();
    PharmacyService ps = new PharmacyService();
   
    public void writeHospitalReqsFile(String fp, HashMap<String, Double> reqs) {
        FileWriter csvWriter;
        String afilePath = new File("").getAbsolutePath();
        String filePath =  fp+"/revenue.csv";
        System.out.print(filePath);
        
        try {
            System.out.println(filePath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
            bw.append("Hospital" + "," +"Revenue"+"\n");

//            csvWriter = new FileWriter(filePath);
            for(Map.Entry<String, Double> s : reqs.entrySet()) {
                
                
                bw.append(hs.getHospital(s.getKey()).getName() + "," + String.valueOf(s.getValue())+"\n");
                
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(CSVService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     public void writePharmacyReqsFile(String fp, HashMap<String, Double> reqs) {
        FileWriter csvWriter;
        String afilePath = new File("").getAbsolutePath();
        String filePath =  fp+"/revenue.csv";
        System.out.print(filePath);
        
        try {
            System.out.println(filePath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
            bw.append("Pharmacy" + "," +"Revenue"+"\n");
//            csvWriter = new FileWriter(filePath);
            for(Map.Entry<String, Double> s : reqs.entrySet()) {
                
                
                bw.append(ps.getPharmacy(s.getKey()).getName() + "," + String.valueOf(s.getValue())+"\n");
                
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(CSVService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    void makeReportOfHospital() {
        
    }
}
