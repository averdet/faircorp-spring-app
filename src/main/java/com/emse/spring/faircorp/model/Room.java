package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private String name;

    private Double currentTemperature;

    private Double targetTemperature;

//    @OneToMany(mappedBy = "room")
//    private List<Heater> heaterList;
//
//    @OneToMany(mappedBy = "room")
//    private List<Window> windowList;

    public Room() {
    }

    public Room(Integer floor, String name) {
        this.floor = floor;
        this.name = name;
    }

    public Room(Integer floor, String name, Double currentTemperature, Double targetTemperature) {
        this.floor = floor;
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
    }

//    public Room(Integer floor, String name, Double currentTemperature, Double targetTemperature, List<Heater> heaterList, List<Window> windowList) {
//        this.floor = floor;
//        this.name = name;
//        this.currentTemperature = currentTemperature;
//        this.targetTemperature = targetTemperature;
//        this.heaterList = heaterList;
//        this.windowList = windowList;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

//    public List<Heater> getHeaterList() {
//        return heaterList;
//    }
//
//    public void setHeaterList(List<Heater> heaterList) {
//        this.heaterList = heaterList;
//    }
//
//    public List<Window> getWindowList() {
//        return windowList;
//    }
//
//    public void setWindowList(List<Window> windowList) {
//        this.windowList = windowList;
//    }
}
