/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.EncounterService;
import java.util.List;

/**
 *
 * @author somes
 */
public class EncounterHistory {
        
        private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = userId;
    }

    
      public EncounterHistory(String id, Boolean patient) {
        this.userId = id;
        EncounterService es = new EncounterService();
//        ArrayList<ArrayList<String>> encounters = es.getEncounterOfUser(id);
//        for(ArrayList<String> encounter: encounters) {
//            this.addEncounter(new Encounter(encounter));
//        }
        if(patient) {
            this.encounterHistory = es.getAllEncountersOfPatient(id);
        } else {
             this.encounterHistory = es.getAllEncountersOfDoctor(id);
           
        }
       }  
	private List<Encounter> encounterHistory;
        
	public List<Encounter> getEncounterHistory() {
		return encounterHistory;
	}
        public void addEncounter(Encounter encounter) {
            this.encounterHistory.add(encounter);
        }
        public void removeEncounter(Encounter e) {
            this.encounterHistory.remove(e);
        }
        
	public void setEncounterHistory(List<Encounter> encounterHistory) {
		this.encounterHistory = encounterHistory;
	}
}

