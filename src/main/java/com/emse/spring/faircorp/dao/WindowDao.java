package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {

    @Modifying
    @Query("delete from Window w where w.room.id = :roomId")
    void deleteAllWindowsFromRoom(@Param("roomId") Long roomId);

    List<Window> findByRoomId(Long roomId);

    List<Window> findByRoomBuildingId(Long buildingId);
}
