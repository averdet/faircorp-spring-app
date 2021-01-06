package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

import java.util.List;

public class BuildingDto {
    private Long id;
    private String name;
    private List<Room> roomList;

    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.roomList = building.getRoomList();
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

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
