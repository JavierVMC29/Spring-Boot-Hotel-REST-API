package com.hotel.api.exception;

import java.io.Serial;

public class ReservationNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 3;

    public ReservationNotFoundException(String message){
        super(message);
    }
}
