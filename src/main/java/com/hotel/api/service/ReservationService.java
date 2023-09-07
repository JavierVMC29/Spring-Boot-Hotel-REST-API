package com.hotel.api.service;

import com.hotel.api.dto.ReservationDto;
import com.hotel.api.dto.ReservationsResponse;

public interface ReservationService {
    ReservationDto createReservation(ReservationDto reservation, int guestId, int roomId);
    ReservationsResponse getAllReservations(int pageNo, int pageSize);
    ReservationDto getReservationById(int id);
    ReservationDto updateReservation(ReservationDto reservationDto, int id);
    void deleteReservationById(int id);
}
