package com.sj.websocket.dto;

import com.sj.websocket.entity.EnteredRoom;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class EnteredRoomResponseDto {

    private Long roomId;
    private String roomName;

    public EnteredRoomResponseDto(EnteredRoom rs) {
        this.roomName = rs.getRoom().getName();
        this.roomId = rs.getRoom().getId();
    }
}
