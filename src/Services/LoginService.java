package Services;

import database.DoctorService;
import database.ForecastOrgAdminService;
import database.HospitalAdminService;
import database.LabAdminService;
import database.ManufacturerService;
import database.PatientService;
import database.PersonService;
import database.PharmaceuticalAdminService;
import database.PharmacyAdminService;
import database.PlanningAdminService;
import database.ReporterService;
import database.RevenueAdminService;
import database.SystemAdminService;
import model.Patient;
import model.Person;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maheshsai
 */
public class LoginService {
    PersonService ps = new PersonService();
    public Person validate(String email, String password) {
        
        Person p = ps.validatePerson(email, password);
        if(p==null) {
            
        }
//        Patient pa = new Patient(p.getId(),p.getName(),p.getEmail(),p.getPassword());
        
        return p;
    }
    public String  register(Person p) {
        String res =  ps.create(p);
        if(p.getRole().equals( "Patient")) {
            PatientService ps = new PatientService();
            res = ps.insertPatient(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "Doctor")) {
            DoctorService ps = new DoctorService();
            res = ps.insertDoctor(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "Manufacturer")) {
            ManufacturerService ps = new ManufacturerService();
            res = ps.insertManufacturer(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "Pharmacy Admin")) {
            PharmacyAdminService ps = new PharmacyAdminService();
            res = ps.insertPharmacyAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "Hospital Admin")) {
            HospitalAdminService ps = new HospitalAdminService();
            res = ps.insertHospitalAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "Planning Admin")) {
            PlanningAdminService ps = new PlanningAdminService();
            res = ps.insertPlanningAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "Revenue Admin")) {
            RevenueAdminService ps = new RevenueAdminService();
            res = ps.insertRevenueAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "Reporter")) {
            ReporterService ps = new ReporterService();
            res = ps.insertReporter(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "Forecast Org Admin")) {
            ForecastOrgAdminService ps = new ForecastOrgAdminService();
            res = ps.insertForecastOrgAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "LabAdmin")) {
            LabAdminService ps = new LabAdminService();
            res = ps.insertLabAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "Pharmaceutical Admin")) {
            PharmaceuticalAdminService ps = new PharmaceuticalAdminService();
            res = ps.insertPharmaceuticalAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } else if(p.getRole().equals( "System Admin")) {
            SystemAdminService ps = new SystemAdminService();
            res = ps.insertSystemAdmin(p.getName(), p.getId(), p.getEmail(), p.getPassword());
        } 
        return res;
    }
    
    
}
