package com.emse.spring.faircorp.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity // (1)
@Table(name = "RWINDOW")// (2)
public class Window {
    @Id// (3)
    @GeneratedValue
    private Long id;

    @Column(nullable = false) // (4)
    private String name;

    @Column(nullable = false) // (5)
    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Room room;

    public Window() {
    }

    public Window(String name, WindowStatus status, Room room) {
        this.windowStatus = status;
        this.name = name;
        this.room = room;
    }

    public Long getId() {
        return this.id;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}