package com.sj.websocket.dto;

import com.sj.websocket.entity.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoomResponseDto {

    private String name;
    private Long roomId;

    public RoomResponseDto(Room room) {
        this.name = room.getName();
        this.roomId = room.getId();
    }
}
