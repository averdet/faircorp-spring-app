package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomDao extends JpaRepository<Room, Long>, RoomDaoCustom {

    @Modifying
    @Query("delete from Room r where r.building.id = :buildingId")
    void deleteAllRoomsFromBuilding(@Param("buildingId") Long buildingId);
}
