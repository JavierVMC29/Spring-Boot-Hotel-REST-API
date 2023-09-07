package com.hotel.api.mapper;

import com.hotel.api.dto.GuestDto;
import com.hotel.api.dto.ReservationDto;
import com.hotel.api.dto.ReservationInfo;
import com.hotel.api.dto.RoomDto;
import com.hotel.api.model.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationMapper {
    public static ReservationDto mapToDto(Reservation reservation){
        ReservationDto reservationDto = new ReservationDto();
        GuestDto guestDto = GuestMapper.mapToDto(reservation.getGuest());
        RoomDto roomDto = RoomMapper.mapToDto(reservation.getRoom());

        reservationDto.setId(reservation.getId());
        reservationDto.setTitle(reservation.getTitle());
        reservationDto.setDateStart(reservation.getDateStart().toString());
        reservationDto.setDateEnd(reservation.getDateEnd().toString());
        reservationDto.setGuest(guestDto);
        reservationDto.setRoom(roomDto);

        return reservationDto;
    }

    public static Reservation mapToEntity(ReservationDto reservationDto){
        Reservation reservation = new Reservation();

        LocalDate dateStart = LocalDate.parse(reservationDto.getDateStart());
        LocalDate dateEnd = LocalDate.parse(reservationDto.getDateEnd());

        reservation.setId(reservationDto.getId());
        reservation.setTitle(reservationDto.getTitle());
        reservation.setDateStart(dateStart);
        reservation.setDateEnd(dateEnd);

        return reservation;
    }

    public static ReservationInfo mapToReservationInfo(Reservation reservation){
        ReservationInfo reservationInfo = new ReservationInfo();

        RoomDto roomDto = RoomMapper.mapToDto(reservation.getRoom());

        reservationInfo.setId(reservation.getId());
        reservationInfo.setTitle(reservation.getTitle());
        reservationInfo.setDateStart(reservation.getDateStart().toString());
        reservationInfo.setDateEnd(reservation.getDateEnd().toString());
        reservationInfo.setRoom(roomDto);

        return reservationInfo;
    }

    public static List<ReservationInfo> mapElementsToReservationInfo(List<Reservation> reservationList){
        return reservationList.stream().map((ReservationMapper::mapToReservationInfo)).collect(Collectors.toList());
    }
}
