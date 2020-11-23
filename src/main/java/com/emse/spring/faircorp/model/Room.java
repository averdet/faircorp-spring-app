package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "RROOM")
public class Room {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private String name;

    private double currentTemperature;

    private double targetTemperature;

    @OneToMany(mappedBy = "room")
    private ArrayList<Heater> heaterList;

    @OneToMany(mappedBy = "room")
    private ArrayList<Window> windowList;

    public Room() {
    }

    public Room(int floor, String name) {
        this.floor = floor;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public ArrayList<Heater> getHeaterList() {
        return heaterList;
    }

    public void setHeaterList(ArrayList<Heater> heaterList) {
        this.heaterList = heaterList;
    }

    public ArrayList<Window> getWindowList() {
        return windowList;
    }

    public void setWindowList(ArrayList<Window> windowList) {
        this.windowList = windowList;
    }
}
