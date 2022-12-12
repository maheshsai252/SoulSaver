/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.EventService;
import java.util.UUID;

/**
 *
 * @author somes
 */
public class EventParticipation {
    String id;
    String event_id;
    String user_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public EventParticipation(String id, String event_id, String user_id) {
        this.id = id;
        this.event_id = event_id;
        this.user_id = user_id;
    }

    public EventParticipation(String event_id, String user_id) {
        this.event_id = event_id;
        this.user_id = user_id;
        this.id = UUID.randomUUID().toString();
    }
    
     @Override
     public String toString() {
         
         return id;
     }
}
