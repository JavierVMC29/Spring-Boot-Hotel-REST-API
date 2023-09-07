package com.hotel.api.mapper;

import com.hotel.api.dto.GuestDto;
import com.hotel.api.dto.GuestReservationsResponse;
import com.hotel.api.dto.ReservationInfo;
import com.hotel.api.model.Guest;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class GuestMapper {
    public static GuestDto mapToDto(Guest guest){
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guest.getId());
        guestDto.setName(guest.getName());
        guestDto.setLastName(guest.getLastName());
        guestDto.setEmail(guest.getEmail());
        return guestDto;
    }

    public static GuestReservationsResponse mapToGuestReservationsResponse(Guest guest){
        GuestReservationsResponse guestReservationsResponse = new GuestReservationsResponse();

        List<ReservationInfo> reservationsInfo = ReservationMapper.mapElementsToReservationInfo(guest.getReservations());

        guestReservationsResponse.setId(guest.getId());
        guestReservationsResponse.setName(guest.getName());
        guestReservationsResponse.setLastName(guest.getLastName());
        guestReservationsResponse.setEmail(guest.getEmail());
        guestReservationsResponse.setReservations(reservationsInfo);

        return guestReservationsResponse;
    }

}
