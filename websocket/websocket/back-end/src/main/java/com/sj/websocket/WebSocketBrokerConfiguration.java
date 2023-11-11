package com.sj.websocket;

import com.sj.websocket.entity.EnteredRoom;
import com.sj.websocket.entity.Room;
import com.sj.websocket.entity.User;
import com.sj.websocket.interceptor.WebsocketBrokerInterceptor;
import com.sj.websocket.repository.WebsocketRoomRepository;
import com.sj.websocket.repository.WebsocketUserRepository;
import com.sj.websocket.service.EnteredRoomService;
import com.sj.websocket.service.RoomService;
import com.sj.websocket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketBrokerConfiguration implements WebSocketMessageBrokerConfigurer {

    private final UserService userService;
    private final RoomService roomService;
    private final EnteredRoomService enteredRoomService;


    private final WebsocketBrokerInterceptor interceptor;
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws/init") //1
                .setAllowedOrigins("*"); //2
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(interceptor);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub"); //topic
        registry.setApplicationDestinationPrefixes("/pub"); // /app
    }

    @EventListener(value = ApplicationReadyEvent.class)
    public void addTestData() {

        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user4 = new User("user4");

        Room room1 = new Room("채팅방1");
        Room room2 = new Room("채팅방2");

        Long savedUserId1 = userService.save(user1);
        Long savedUserId2 = userService.save(user2);
        Long savedUserId3 = userService.save(user3);
        Long savedUserId4 = userService.save(user4);


        Long savedRoomId1 = roomService.save(room1);
        Long savedRoomId2 = roomService.save(room2);

        enteredRoomService.save(savedUserId1, savedRoomId1);
        enteredRoomService.save(savedUserId2, savedRoomId1);
        enteredRoomService.save(savedUserId3, savedRoomId1);

        enteredRoomService.save(savedUserId3, savedRoomId2);
        enteredRoomService.save(savedUserId4, savedRoomId2);
    }
}
