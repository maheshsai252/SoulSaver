/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author maheshsai
 */
public class Pharmaceutical {
    String id;
    String name;

    public Pharmaceutical(String name) {
        this.name = name;
        this.id =UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
    @Override
    public String toString() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pharmaceutical(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
