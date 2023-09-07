package com.hotel.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationDto {
    private int id;
    private String title;
    private String dateStart;
    private String dateEnd;
    private RoomDto room;
    private GuestDto guest;
}
