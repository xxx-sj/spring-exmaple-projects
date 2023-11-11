package com.sj.websocket.repository;

import com.sj.websocket.entity.EnteredRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsocketEnteredRoomRepository extends JpaRepository<EnteredRoom, Long> {
}
