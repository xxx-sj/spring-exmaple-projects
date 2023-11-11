package com.sj.websocket.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Room {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "room")
    private List<EnteredRoom> enteredRoom = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }
}
