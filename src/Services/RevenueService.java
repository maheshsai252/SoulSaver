/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import database.DoctorService;
import database.EncounterService;
import database.HospitalDBService;
import database.TransactionLogService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import model.Doctor;
import model.Encounter;
import model.Hospital;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;
import java.util.Calendar;
import model.TransactionLog;
/**
 *
 * @author maheshsai
 */
public class RevenueService {
    DoctorService ds = new DoctorService();
    EncounterService es = new EncounterService();
    TransactionLogService ts = new TransactionLogService();
    public double getRevenue(String hid) {
        HospitalDBService hs = new HospitalDBService();
        ArrayList<Encounter> encounters = es.getAllEncounters();
        ArrayList<Encounter> desired = new ArrayList<>();
        for(Encounter e: encounters) {
             if(e.getDoctor()!=null && e.getDoctor().getHospital() != null) {
                    if(e.getDoctor().getHospital().getId().equals(hid)) {
                        desired.add(e);
                    }
            }
            
        }
        double revenue = 0;
        for(Encounter e: desired) {
            revenue+=e.getCharges();
        }
        return revenue;
    }
    public HashMap<String, Double> getRevenue(Date from, Date  to) {
        HashMap<String, Double> hm = new HashMap<>();

        HospitalDBService hs = new HospitalDBService();
        ArrayList<Encounter> encounters = es.getAllEncounters(from, to);
        ArrayList<Encounter> desired = new ArrayList<>();
        for(Encounter e: encounters) {
             if(e.getDoctor()!=null && e.getDoctor().getHospital() != null) {
                    if(hm.containsKey(e.getDoctor().getHospitalId())) {
                        hm. put(e.getDoctor().getHospitalId(), hm.get(e.getDoctor().getHospitalId()) + e.getCharges());
                        
                    } else {
                       hm. put(e.getDoctor().getHospitalId(),  + e.getCharges());

                    }
            }
            
        }
        
        return hm;
    }
    public HashMap<String, Double> getAllRevenues() {
        HashMap<String, Double> hm = new HashMap<>();
        ArrayList<Encounter> encounters = es.getAllEncounters();
        ArrayList<Encounter> desired = new ArrayList<>();
        
        for(Encounter e: encounters) {
            System.out.println(e.getId()+"encounter");
            System.out.println(e.getDoctor());
//            System.out.println(e.getDoctor().getHospital()+"hospi");
             if(e.getDoctor()!=null && e.getDoctor().getHospital() != null) {
                    if(hm.containsKey(e.getDoctor().getHospitalId())) {
                        hm. put(e.getDoctor().getHospitalId(), hm.get(e.getDoctor().getHospitalId()) + e.getCharges());
                        
                    } else {
                       hm. put(e.getDoctor().getHospitalId(),  e.getCharges());

                    }
            }
            
        }
        System.out.println(hm);
        
        return hm;
    }
    public HashMap<String, Double> getAllRevenuesOfPharmacies() {
        HashMap<String, Double> hm = new HashMap<>();
        ArrayList<TransactionLog> encounters = this.ts.getAllTransactionLogs();
        System.out.println(encounters);
        for(TransactionLog e: encounters) {
            
             if(e.getPharmacy_id()!=null) {
                    if(hm.containsKey(e.getPharmacy_id())) {
                        hm. put(e.getPharmacy_id(), hm.get(e.getPharmacy_id()) + e.getCost());
                        
                    } else {
                       hm. put(e.getPharmacy_id(),  e.getCost());

                    }
            }
            
        }        
        return hm;
    }
    public HashMap<String, Double> getAllRevenuesOfInventories() {
        HashMap<String, Double> hm = new HashMap<>();
        ArrayList<TransactionLog> encounters = this.ts.getAllTransactionLogs();
        System.out.println(encounters);
        for(TransactionLog e: encounters) {
            
             if(e.getPharmacy_id()!=null) {
                    if(hm.containsKey(e.getPharmacy_id())) {
                        hm. put(e.getInventory_item_id(), hm.get(e.getInventory_item_id()) + e.getCost());
                        
                    } else {
                       hm. put(e.getInventory_item_id(),  e.getCost());

                    }
            }
            
        }        
        return hm;
    }
    public HashMap<String, Double> getAllRevenuesofhospitals(int fromYear, int  toyear) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, fromYear);
        Date from = new Date(calendar.getTime().getTime());
        System.out.println(fromYear);
        
        Calendar calendarw = Calendar.getInstance();
        calendarw.set(Calendar.YEAR, toyear);
        Date to = new Date(calendarw.getTime().getTime());
        
        LocalDate now = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now2 = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 2015-11-23
        LocalDate firstDay = now.with(firstDayOfYear()); // 2015-01-01
        LocalDate lastDay = now2.with(lastDayOfYear()); // 2015-12-31
        Date fromdate = Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date todate = Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

        HashMap<String, Double> hm = new HashMap<>();
        ArrayList<Encounter> encounters = es.getAllEncounters(fromdate,todate);
        ArrayList<Encounter> desired = new ArrayList<>();
        
        for(Encounter e: encounters) {
             if(e.getDoctor()!=null && e.getDoctor().getHospitalId() != null) {
                    if(hm.containsKey(e.getDoctor().getHospitalId())) {
                        hm. put(e.getDoctor().getHospitalId(), hm.get(e.getDoctor().getHospitalId()) + e.getCharges());
                        
                    } else {
                       hm. put(e.getDoctor().getHospitalId(),  + e.getCharges());

                    }
            }
            
        }
        return hm;
    }
    public HashMap<String, Double> getAllRevenuesofgivenhospitals(ArrayList<String> hids) {
        
        HashMap<String, Double> hm = new HashMap<>();
        ArrayList<Encounter> encounters = es.getAllEncounters();
        
        for(Encounter e: encounters) {
             if(e.getDoctor()!=null && e.getDoctor().getHospitalId() != null && hids.contains(e.getDoctor().getHospitalId())) {
                    if(hm.containsKey(e.getDoctor().getHospitalId())) {
                        hm. put(e.getDoctor().getHospitalId(), hm.get(e.getDoctor().getHospitalId()) + e.getCharges());
                        
                    } else {
                       hm. put(e.getDoctor().getHospitalId(),  + e.getCharges());

                    }
            }
            
        }
        return hm;
    }
      public HashMap<String, Double> getAllRevenuesofgivenpharmacys(ArrayList<String> hids) {
        
        
    
        HashMap<String, Double> hm = new HashMap<>();
        ArrayList<TransactionLog> encounters = this.ts.getAllTransactionLogs();
        System.out.println(encounters);
        for(TransactionLog e: encounters) {
            
             if(e.getPharmacy_id()!=null && hids.contains(e.getPharmacy_id())) {
                    if(hm.containsKey(e.getPharmacy_id())) {
                        hm. put(e.getPharmacy_id(), hm.get(e.getPharmacy_id()) + e.getCost());
                        
                    } else {
                       hm. put(e.getPharmacy_id(),  e.getCost());

                    }
            }
            
        }        
        return hm;
    }
    public HashMap<Integer, Double> getAllRevenuesofhospitalbymonth(String hid, int fromYear, int  toyear) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, fromYear);
        Date from = new Date(calendar.getTime().getTime());
        System.out.println(fromYear);
        
        Calendar calendarw = Calendar.getInstance();
        calendarw.set(Calendar.YEAR, toyear);
        Date to = new Date(calendarw.getTime().getTime());
        
        LocalDate now = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now2 = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 2015-11-23
        LocalDate firstDay = now.with(firstDayOfYear()); // 2015-01-01
        LocalDate lastDay = now2.with(lastDayOfYear()); // 2015-12-31
        Date fromdate = Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date todate = Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

        HashMap<Integer, Double> hm = new HashMap<>();
        ArrayList<Encounter> encounters = es.getAllEncounters(fromdate,todate);
        ArrayList<Encounter> desired = new ArrayList<>();
        
        for(Encounter e: encounters) {
             if(e.getDoctor()!=null && e.getDoctor().getHospital() != null && e.getDoctor().getHospitalId().equals(hid)) {
                   calendar.setTime(e.getEncounteredTime());
                  
                 if(hm.containsKey(calendar.get(Calendar.MONTH))) {
                        hm. put(calendar.get(Calendar.MONTH), hm.get(calendar.get(Calendar.MONTH)) + e.getCharges());
                        
                    } else {
                       hm. put(calendar.get(Calendar.MONTH),  e.getCharges());

                    }
            }
            
        }
        return hm;
    }
     public HashMap<Integer, Double> getAllRevenuesofhospitalbyyear(String hid) {
        
        
        Calendar calendar = Calendar.getInstance();
        
        HashMap<Integer, Double> hm = new HashMap<>();
        ArrayList<Encounter> encounters = es.getAllEncounters();
        
        for(Encounter e: encounters) {
            
            
             if(e.getDoctor()!=null && e.getDoctor().getHospital() != null && e.getDoctor().getHospitalId().equals(hid)) {
                 calendar.setTime(e.getEncounteredTime());
                 
                 if(hm.containsKey(calendar.get(Calendar.YEAR))) {
                        hm. put(calendar.get(Calendar.YEAR), hm.get(calendar.get(Calendar.YEAR)) + e.getCharges());
                        
                    } else {
                       hm. put(calendar.get(Calendar.YEAR),  e.getCharges());

                    }
            }
            
        }
        System.out.println(hm);
        return hm;
    }
    public HashMap<Integer, Double> getAllRevenuesofhospitalbyyear(String hid, int fromYear, int  toyear) {
        
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, fromYear);
        Date from = new Date(calendar.getTime().getTime());
        System.out.println(fromYear);
        
        Calendar calendarw = Calendar.getInstance();
        calendarw.set(Calendar.YEAR, toyear);
        Date to = new Date(calendarw.getTime().getTime());
        LocalDate now = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now2 = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(now);
        System.out.println(now2);

        // 2015-11-23
        LocalDate firstDay = now.with(firstDayOfYear()); // 2015-01-01
        LocalDate lastDay = now2.with(lastDayOfYear()); // 2015-12-31
        System.out.println(firstDay);
System.out.println(lastDay);
        Date fromdate = Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date todate = Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
 System.out.println(fromdate);
System.out.println(todate);
        HashMap<Integer, Double> hm = new HashMap<>();
        ArrayList<Encounter> encounters = es.getAllEncounters(fromdate,todate);
        DoctorService ds = new DoctorService();
        for(Encounter e: encounters) {
            Doctor doc = ds.getDoctor(e.getDoctorId());
            System.out.println("checking doc"+doc);

             if(doc!=null && doc.getHospitalId() != null && doc.getHospitalId().equals(hid)) {
                 calendar.setTime(e.getEncounteredTime());
                 
                 if(hm.containsKey(calendar.get(Calendar.YEAR))) {
                        hm. put(calendar.get(Calendar.YEAR), hm.get(calendar.get(Calendar.YEAR)) + e.getCharges());
                        
                    } else {
                       hm. put(calendar.get(Calendar.YEAR),  e.getCharges());

                    }
            }
            
        }
        System.out.println(hm);
        return hm;
    }
    
    //revenue of pharmacy 
    
    public HashMap<Integer, Double> getAllRevenuesofPharmacybymonth(String pid, int fromYear, int  toyear) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, fromYear);
        Date from = new Date(calendar.getTime().getTime());
        System.out.println(fromYear);
        
        Calendar calendarw = Calendar.getInstance();
        calendarw.set(Calendar.YEAR, toyear);
        Date to = new Date(calendarw.getTime().getTime());
        
        LocalDate now = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now2 = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 2015-11-23
        LocalDate firstDay = now.with(firstDayOfYear()); // 2015-01-01
        LocalDate lastDay = now2.with(lastDayOfYear()); // 2015-12-31
        Date fromdate = Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date todate = Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

        HashMap<Integer, Double> hm = new HashMap<>();
        ArrayList<TransactionLog> encounters = ts.getAllTransactionLogs(pid, fromdate, todate);
        
        for(TransactionLog e: encounters) {
                 calendar.setTime(e.getDate());   
                 if(hm.containsKey(calendar.get(Calendar.MONTH))) {
                        hm. put(calendar.get(Calendar.MONTH), e.getCost());
                        
                    } else {
                       hm. put(calendar.get(Calendar.MONTH),  e.getCost());

                    }
            }
            
        
        return hm;
    }
    public HashMap<Integer, Double> getAllRevenuesofPharmacybyyear(String pid, int fromYear, int  toyear) {
        
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, fromYear);
        Date from = new Date(calendar.getTime().getTime());
        System.out.println(fromYear);
        
        Calendar calendarw = Calendar.getInstance();
        calendarw.set(Calendar.YEAR, toyear);
        Date to = new Date(calendarw.getTime().getTime());
        
        LocalDate now = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now2 = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 2015-11-23
        LocalDate firstDay = now.with(firstDayOfYear()); // 2015-01-01
        LocalDate lastDay = now2.with(lastDayOfYear()); // 2015-12-31
        Date fromdate = Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date todate = Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

        HashMap<Integer, Double> hm = new HashMap<>();
        ArrayList<TransactionLog> encounters = ts.getAllTransactionLogs(pid, fromdate, todate);
        
        for(TransactionLog e: encounters) {
                 calendar.setTime(e.getDate());   
                 if(hm.containsKey(calendar.get(Calendar.YEAR))) {
                        hm. put(calendar.get(Calendar.YEAR), e.getCost());
                        
                    } else {
                       hm. put(calendar.get(Calendar.YEAR),  e.getCost());

                    }
            }
            
        
        return hm;
    }
    public HashMap<Integer, Double> getAllRevenuesofInventorybyyear(String pid, int fromYear, int  toyear) {
        
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, fromYear);
        Date from = new Date(calendar.getTime().getTime());
        System.out.println(fromYear);
        
        Calendar calendarw = Calendar.getInstance();
        calendarw.set(Calendar.YEAR, toyear);
        Date to = new Date(calendarw.getTime().getTime());
        
        LocalDate now = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now2 = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 2015-11-23
        LocalDate firstDay = now.with(firstDayOfYear()); // 2015-01-01
        LocalDate lastDay = now2.with(lastDayOfYear()); // 2015-12-31
        Date fromdate = Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date todate = Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

        HashMap<Integer, Double> hm = new HashMap<>();
        ArrayList<TransactionLog> encounters = ts.getAllInventoryTransactionLogsofInventory(pid, fromdate, todate);
        
        for(TransactionLog e: encounters) {
                 calendar.setTime(e.getDate());   
                 if(hm.containsKey(calendar.get(Calendar.YEAR))) {
                        hm. put(calendar.get(Calendar.YEAR), e.getCost());
                        
                    } else {
                       hm. put(calendar.get(Calendar.YEAR),  e.getCost());

                    }
            }
            
        
        return hm;
    }
    public HashMap<Integer, Double> getAllRevenuesofInventorybymonth(String pid, int fromYear, int  toyear) {
        
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, fromYear);
        Date from = new Date(calendar.getTime().getTime());
        System.out.println(fromYear);
        
        Calendar calendarw = Calendar.getInstance();
        calendarw.set(Calendar.YEAR, toyear);
        Date to = new Date(calendarw.getTime().getTime());
        
        LocalDate now = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now2 = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 2015-11-23
        LocalDate firstDay = now.with(firstDayOfYear()); // 2015-01-01
        LocalDate lastDay = now2.with(lastDayOfYear()); // 2015-12-31
        Date fromdate = Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date todate = Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

        HashMap<Integer, Double> hm = new HashMap<>();
        ArrayList<TransactionLog> encounters = ts.getAllInventoryTransactionLogsofInventory(pid, fromdate, todate);
        
        for(TransactionLog e: encounters) {
                 calendar.setTime(e.getDate());   
                 if(hm.containsKey(calendar.get(Calendar.MONTH))) {
                        hm. put(calendar.get(Calendar.MONTH), e.getCost());
                        
                    } else {
                       hm. put(calendar.get(Calendar.MONTH),  e.getCost());

                    }
            }
            
        
        return hm;
    }
    public HashMap<Integer, Double> getAllRevenuesofPharmacybyyear(String pid) {
        
        
        Calendar calendar = Calendar.getInstance();
        
        HashMap<Integer, Double> hm = new HashMap<>();
        ArrayList<TransactionLog> encounters = ts.getAllTransactionLogsOfPharmacy(pid);
        
        for(TransactionLog e: encounters) {
                 calendar.setTime(e.getDate());   
                 if(hm.containsKey(calendar.get(Calendar.YEAR))) {
                        hm. put(calendar.get(Calendar.YEAR), e.getCost());
                        
                    } else {
                       hm. put(calendar.get(Calendar.YEAR),  e.getCost());

                    }
            }
            
        
        return hm;
    }
    public HashMap<Integer, Double> getAllRevenuesofInventoryItembyyear(String pid) {
        
        
        Calendar calendar = Calendar.getInstance();
        
        HashMap<Integer, Double> hm = new HashMap<>();
        ArrayList<TransactionLog> encounters = ts.getAllInventoryTransactionLogsofInventory(pid);
        
        for(TransactionLog e: encounters) {
                 calendar.setTime(e.getDate());   
                 if(hm.containsKey(calendar.get(Calendar.YEAR))) {
                        hm. put(calendar.get(Calendar.YEAR), e.getCost());
                        
                    } else {
                       hm. put(calendar.get(Calendar.YEAR),  e.getCost());

                    }
            }
            
        
        return hm;
    }
}
