package com.hotel.api.service;

import com.hotel.api.dto.GuestDto;
import com.hotel.api.dto.GuestReservationsResponse;
import com.hotel.api.dto.GuestsResponse;
import com.hotel.api.model.Guest;

public interface GuestService {
    GuestDto createGuest(Guest guest);
    GuestsResponse getAllGuests(int pageNo, int pageSize);
    GuestDto getGuestById(int id);
    GuestDto updateGuest(GuestDto guestDto, int id);
    void deleteGuestById(int id);

    GuestReservationsResponse getGuestReservations(int id);
}
