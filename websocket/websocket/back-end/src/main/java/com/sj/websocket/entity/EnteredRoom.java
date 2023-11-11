package com.sj.websocket.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class EnteredRoom {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @Enumerated(value = EnumType.STRING)
    private RoomStatus roomStatus = RoomStatus.ENTER;

    public EnteredRoom(User user, Room room) {
        this.user = user;
        this.room = room;
    }
}
