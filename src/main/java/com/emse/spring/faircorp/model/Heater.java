package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "HEATER")
public class Heater {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private long power;

    @Column(nullable = false) // (5)
    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;

    @ManyToOne(optional = false)
    private Room room;

    public Heater() {
    }

    public Heater(String name, long power, HeaterStatus heaterStatus, Room room) {
        this.name = name;
        this.power = power;
        this.heaterStatus = heaterStatus;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
