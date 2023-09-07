package com.hotel.api.controller;

import com.hotel.api.dto.RoomDto;
import com.hotel.api.dto.RoomsResponse;
import com.hotel.api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("rooms")
    public ResponseEntity<RoomsResponse> getRooms(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        return new ResponseEntity<>(roomService.getAllRooms(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("rooms/{id}")
    public ResponseEntity<RoomDto> roomDetail(@PathVariable int id){
        return new ResponseEntity<>(roomService.getRoomById(id), HttpStatus.OK);
    }

    @PostMapping("rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto room){
        return new ResponseEntity<>(roomService.createRoom(room), HttpStatus.CREATED);
    }

    @PutMapping("rooms/{id}")
    public ResponseEntity<RoomDto> updateRoom(@RequestBody RoomDto roomDto, @PathVariable("id") int roomId){
        RoomDto response = roomService.updateRoom(roomDto, roomId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("rooms/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") int roomId){
        roomService.deleteRoomById(roomId);
        return new ResponseEntity<>("Room deleted", HttpStatus.OK);
    }
}
