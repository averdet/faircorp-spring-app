package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private double currentTemperature;

    @Column(nullable = true)
    private double targetTemperature;

    @OneToMany(mappedBy = "room")
    private List<Heater> heaterList;

    @OneToMany(mappedBy = "room")
    private List<Window> windowList;

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

    public List<Heater> getHeaterList() {
        return heaterList;
    }

    public void setHeaterList(List<Heater> heaterList) {
        this.heaterList = heaterList;
    }

    public List<Window> getWindowList() {
        return windowList;
    }

    public void setWindowList(List<Window> windowList) {
        this.windowList = windowList;
    }
}
