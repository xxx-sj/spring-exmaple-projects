package com.sj.websocket.service;

import com.sj.websocket.Result;
import com.sj.websocket.dto.EnteredRoomResponseDto;
import com.sj.websocket.dto.RoomResponseDto;
import com.sj.websocket.entity.EnteredRoom;
import com.sj.websocket.entity.Room;
import com.sj.websocket.entity.RoomStatus;
import com.sj.websocket.entity.User;
import com.sj.websocket.repository.WebsocketEnteredRoomRepository;
import com.sj.websocket.repository.WebsocketRoomRepository;
import com.sj.websocket.repository.WebsocketUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoomService {

    private final WebsocketRoomRepository repository;
    private final WebsocketEnteredRoomRepository enteredRoomRepository;
    private final WebsocketUserRepository userRepository;

    @Transactional
    public Long save(Room room) {
        return repository.save(room).getId();
    }


    public Result<List<RoomResponseDto>> findAll() {
        List<Room> rooms = repository.findAll();
        List<RoomResponseDto> collect = rooms.stream().map(RoomResponseDto::new).collect(Collectors.toList());

        return new Result<>(collect);
    }

    public Result<List<EnteredRoomResponseDto>> findAll(Long userId) {
        User user = userRepository.findById(userId).get();
        List<EnteredRoom> findRooms = enteredRoomRepository.findAll(RoomStatus.ENTER, user);

        List<EnteredRoomResponseDto> collect = findRooms.stream().map(EnteredRoomResponseDto::new).collect(Collectors.toList());

        return new Result<>(collect);

    }
}
