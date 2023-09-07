package com.hotel.api.dto;

import lombok.Data;

@Data
public class ReservationInfo {
    private int id;
    private String title;
    private String dateStart;
    private String dateEnd;
    private RoomDto room;
}
