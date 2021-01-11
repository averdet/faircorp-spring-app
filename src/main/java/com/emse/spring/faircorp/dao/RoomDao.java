package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDao extends JpaRepository<Room, Long>, RoomDaoCustom {

    List<Room> findByBuildingId(Long buildingId);

    @Modifying
    @Query("delete from Room r where r.building.id = :buildingId")
    void deleteAllRoomsFromBuilding(@Param("buildingId") Long buildingId);
}
