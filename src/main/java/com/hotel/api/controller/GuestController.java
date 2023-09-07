package com.hotel.api.controller;

import com.hotel.api.dto.GuestDto;
import com.hotel.api.dto.GuestReservationsResponse;
import com.hotel.api.dto.GuestsResponse;
import com.hotel.api.model.Guest;
import com.hotel.api.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("guests")
    public ResponseEntity<GuestsResponse> getGuests(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        return new ResponseEntity<>(guestService.getAllGuests(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("guests/{id}")
    public ResponseEntity<GuestDto> guestDetail(@PathVariable int id){
        return new ResponseEntity<>(guestService.getGuestById(id), HttpStatus.OK);
    }

    @PostMapping("guests")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GuestDto> createGuest(@RequestBody Guest guest){
        return new ResponseEntity<>(guestService.createGuest(guest), HttpStatus.CREATED);
    }

    @PutMapping("guests/{id}")
    public ResponseEntity<GuestDto> updateGuest(@RequestBody GuestDto guestDto, @PathVariable("id") int guestId){
        GuestDto response = guestService.updateGuest(guestDto, guestId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("guests/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable("id") int guestId){
        guestService.deleteGuestById(guestId);
        return new ResponseEntity<>("Guest deleted", HttpStatus.OK);
    }

    @GetMapping("guests/{id}/reservations")
    public ResponseEntity<GuestReservationsResponse> guestReservations(@PathVariable int id){
        return new ResponseEntity<>(guestService.getGuestReservations(id), HttpStatus.OK);
    }
}
