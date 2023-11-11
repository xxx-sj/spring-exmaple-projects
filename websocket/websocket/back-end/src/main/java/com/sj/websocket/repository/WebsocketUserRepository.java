package com.sj.websocket.repository;

import com.sj.websocket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsocketUserRepository extends JpaRepository<User, Long> {
}
