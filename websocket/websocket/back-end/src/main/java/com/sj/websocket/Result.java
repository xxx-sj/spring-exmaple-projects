package com.sj.websocket;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Result<T> {

    private T data;

    public Result(T data) {
        this.data = data;
    }
}
