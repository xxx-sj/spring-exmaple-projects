package com.sj.websocket.service;

import com.sj.websocket.entity.EnteredRoom;
import com.sj.websocket.entity.Room;
import com.sj.websocket.entity.User;
import com.sj.websocket.repository.WebsocketEnteredRoomRepository;
import com.sj.websocket.repository.WebsocketRoomRepository;
import com.sj.websocket.repository.WebsocketUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EnteredRoomService {

    private final WebsocketEnteredRoomRepository repository;
    private final WebsocketUserRepository userRepository;
    private final WebsocketRoomRepository roomRepository;

    @Transactional
    public Long save(Long userId, Long roomId) {

        User user = userRepository.findById(userId).get();
        Room room = roomRepository.findById(roomId).get();
        EnteredRoom enteredRoom = new EnteredRoom(user, room);

        return repository.save(enteredRoom).getId();
    }
}
