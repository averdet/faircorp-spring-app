package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "RHEATER")
public class Heater {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long power;

    @ManyToOne(optional = false)
    private Room room;

    public Heater() {
    }

    public Heater(String name, long power, Room room) {
        this.name = name;
        this.power = power;
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
