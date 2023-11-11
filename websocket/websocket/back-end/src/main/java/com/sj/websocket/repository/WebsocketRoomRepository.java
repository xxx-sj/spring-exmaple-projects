package com.sj.websocket.repository;

import com.sj.websocket.entity.Room;
import com.sj.websocket.entity.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WebsocketRoomRepository extends JpaRepository<Room, Long> {

    @Query("select distinct r from Room r join fetch EnteredRoom e where e.roomStatus != :roomStatus")
    List<Room> findAll(@Param(value = "roomStatus") RoomStatus roomStatus);
}
