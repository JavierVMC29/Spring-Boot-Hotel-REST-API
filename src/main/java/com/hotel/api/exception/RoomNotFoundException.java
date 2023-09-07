package com.hotel.api.exception;

import java.io.Serial;

public class RoomNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 2;

    public RoomNotFoundException(String message){
        super(message);
    }
}
