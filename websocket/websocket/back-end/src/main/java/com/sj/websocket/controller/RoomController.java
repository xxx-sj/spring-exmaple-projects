package com.sj.websocket.controller;

import com.sj.websocket.Result;
import com.sj.websocket.dto.EnteredRoomResponseDto;
import com.sj.websocket.dto.RoomJoinedRequestDto;
import com.sj.websocket.dto.RoomResponseDto;
import com.sj.websocket.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/room")
public class RoomController {

    private final RoomService service;

    @GetMapping("")
    public Result<List<RoomResponseDto>> list() {

        return service.findAll();
    }

    @GetMapping("/joined")
    public Result<List<EnteredRoomResponseDto>> joinedList(RoomJoinedRequestDto requestDto) {
        return service.findAll(requestDto.getUserId());
    }
}
