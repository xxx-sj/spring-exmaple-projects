package com.sj.websocket.service;

import com.sj.websocket.entity.User;
import com.sj.websocket.repository.WebsocketUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final WebsocketUserRepository repository;

    @Transactional
    public Long save(User user) {
        return repository.save(user).getId();
    }
}
