package com.hotel.api.controller;

import com.hotel.api.dto.ReservationDto;
import com.hotel.api.dto.ReservationsResponse;
import com.hotel.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("reservations")
    public ResponseEntity<ReservationsResponse> getReservations(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        return new ResponseEntity<>(reservationService.getAllReservations(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("reservations/{id}")
    public ResponseEntity<ReservationDto> reservationDetail(@PathVariable int id){
        return new ResponseEntity<>(reservationService.getReservationById(id), HttpStatus.OK);
    }

    @PostMapping("reservations")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservation, @RequestParam int guestId, @RequestParam int roomId){
        return new ResponseEntity<>(reservationService.createReservation(reservation, guestId, roomId), HttpStatus.CREATED);
    }

    @PutMapping("reservations/{id}")
    public ResponseEntity<ReservationDto> updateReservation(@RequestBody ReservationDto reservationDto, @PathVariable("id") int reservationId){
        ReservationDto response = reservationService.updateReservation(reservationDto, reservationId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("reservations/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") int reservationId){
        reservationService.deleteReservationById(reservationId);
        return new ResponseEntity<>("Reservation deleted", HttpStatus.OK);
    }
}
