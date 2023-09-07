package com.hotel.api.service;

import com.hotel.api.dto.RoomDto;
import com.hotel.api.dto.RoomsResponse;

public interface RoomService {
    RoomDto createRoom(RoomDto room);
    RoomsResponse getAllRooms(int pageNo, int pageSize);
    RoomDto getRoomById(int id);
    RoomDto updateRoom(RoomDto roomDto, int id);
    void deleteRoomById(int id);
}
