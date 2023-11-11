package com.sj.websocket.repository;

import com.sj.websocket.entity.EnteredRoom;
import com.sj.websocket.entity.RoomStatus;
import com.sj.websocket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WebsocketEnteredRoomRepository extends JpaRepository<EnteredRoom, Long> {


    @Query("SELECT er FROM EnteredRoom er JOIN FETCH er.room r WHERE er.user = :user AND er.roomStatus = :roomStatus")
    List<EnteredRoom> findAll(@Param("roomStatus") RoomStatus roomStatus, @Param("user") User user);
}
