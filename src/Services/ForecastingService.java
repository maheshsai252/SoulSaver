/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author maheshsai
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.jfree.data.statistics.Regression;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ForecastingService {
  
  public ForecastingService() {
    
  }
  RevenueService rs = new RevenueService();
  public ArrayList<Double> testOLSRegression1b(Double[] data, int predictionsLen) {
    
    XYSeries series = new XYSeries("Test");
    for (int i = 0; i < data.length; i++) {
        series.add(i, data[i]);
    }
    double d[] = new double[predictionsLen];
    for(int i=0;i<predictionsLen;i++) {
        d[i] = i;
    }
    XYDataset ds = new XYSeriesCollection(series);
    
    double[] result = Regression.getOLSRegression(ds, 0);
    double m = result[0];
    double c = result[1];
    ArrayList<Double> ans = new ArrayList<>();
    for(double di: d) {
        ans.add(c + (m * di));
    }
    return ans;
}
  public HashMap<Integer, Double> forecastHospitalRevenueByYear(String hid, int years) {
      HashMap<Integer, Double> hrevenue =  this.rs.getAllRevenuesofhospitalbyyear(hid);
      System.out.println(hrevenue + "revenue of hsptl");
      ArrayList<Double> ans;
      try {
      ans = testOLSRegression1b(hrevenue.values().toArray(new Double[hrevenue.values().size()]),years);
      System.out.println(ans);
      Integer max = Collections.max(hrevenue.keySet());
      for(int i=0;i<years;i++) {
          hrevenue.put(max+i, ans.get(i));
      }
      } catch(Exception e) {
          System.out.println(e.getMessage());
      }
      return hrevenue;
  }
  
  public HashMap<Integer, Double>  forecastPharmacyRevenue(String hid, int years) {
      HashMap<Integer, Double> hrevenue =  this.rs.getAllRevenuesofPharmacybyyear(hid);
      ArrayList<Double> ans;
      try {
      ans = testOLSRegression1b(hrevenue.values().toArray(new Double[hrevenue.values().size()]),years);
      System.out.println(ans);
      Integer max = Collections.max(hrevenue.keySet());
      for(int i=0;i<years;i++) {
          hrevenue.put(max+i, ans.get(i));
      }
      } catch(Exception e) {
          System.out.println(e.getMessage());
      }
      return hrevenue;
  }

  public HashMap<Integer, Double> forecastInventoryItemRevenue(String hid, int years) {
      HashMap<Integer, Double> hrevenue =  this.rs.getAllRevenuesofInventoryItembyyear(hid);
      ArrayList<Double> ans;
      try {
      ans = testOLSRegression1b(hrevenue.values().toArray(new Double[hrevenue.values().size()]),years);
      System.out.println(ans);
      Integer max = Collections.max(hrevenue.keySet());
      for(int i=0;i<years;i++) {
          hrevenue.put(max+i, ans.get(i));
      }
      } catch(Exception e) {
          System.out.println(e.getMessage());
      }
      return hrevenue;
            
  }
}