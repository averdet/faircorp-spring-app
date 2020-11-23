package com.emse.spring.faircorp.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity // (1)
@Table(name = "RWINDOW")// (2)
public class Window {
    @Id// (3)
    @GeneratedValue
    private Long id;

    @NonNull // (4)
    private String name;

    @NonNull// (5)
    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;

    public Window() {
    }

    public Window(String name, WindowStatus status) {
        this.windowStatus = status;
        this.name = name;
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
}