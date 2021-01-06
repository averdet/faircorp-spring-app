package com.emse.spring.faircorp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "HEATER")
public class Heater {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private Long power;

    @Column(nullable = false) // (5)
    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Room room;

    public Heater() {
    }

    public Heater(String name, Long power, HeaterStatus heaterStatus, Room room) {
        this.name = name;
        this.power = power;
        this.heaterStatus = heaterStatus;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
