package com.hotel.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class GuestReservationsResponse{
    private int id;
    private String name;
    private String lastName;
    private String email;
    private List<ReservationInfo> reservations;
}
