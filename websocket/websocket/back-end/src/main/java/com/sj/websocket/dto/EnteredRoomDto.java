package com.sj.websocket.dto;

import com.sj.websocket.entity.EnteredRoom;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class EnteredRoomDto {

    private String username;

    public EnteredRoomDto(EnteredRoom r) {
        this.username = r.getUser().getName();
    }
}
