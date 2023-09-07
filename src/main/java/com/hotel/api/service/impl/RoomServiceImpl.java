package com.hotel.api.service.impl;

import com.hotel.api.dto.RoomDto;
import com.hotel.api.dto.RoomsResponse;
import com.hotel.api.exception.RoomNotFoundException;
import com.hotel.api.mapper.RoomMapper;
import com.hotel.api.model.Room;
import com.hotel.api.repository.RoomRepository;
import com.hotel.api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        Room room = RoomMapper.mapToEntity(roomDto);
        Room newRoom = roomRepository.save(room);
        return RoomMapper.mapToDto(newRoom);
    }

    @Override
    public RoomsResponse getAllRooms(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Room> rooms = roomRepository.findAll(pageable);
        List<Room> listOfRooms = rooms.getContent();
        List<RoomDto> content = listOfRooms.stream().map(RoomMapper::mapToDto).collect(Collectors.toList());

        RoomsResponse roomsResponse = new RoomsResponse();
        roomsResponse.setContent(content);
        roomsResponse.setPageNo(rooms.getNumber());
        roomsResponse.setPageSize(rooms.getSize());
        roomsResponse.setTotalElements(rooms.getTotalElements());
        roomsResponse.setTotalPages(rooms.getTotalPages());
        roomsResponse.setLast(rooms.isLast());

        return roomsResponse;
    }

    @Override
    public RoomDto getRoomById(int id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException("Room could not be found"));
        return RoomMapper.mapToDto(room);
    }

    @Override
    public RoomDto updateRoom(RoomDto roomDto, int id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException("Room could not be found"));

        room.setNumber(roomDto.getNumber());
        room.setType(roomDto.getType());

        Room updatedRoom = roomRepository.save(room);

        return RoomMapper.mapToDto(updatedRoom);
    }

    @Override
    public void deleteRoomById(int id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException("Room could not be found"));
        roomRepository.delete(room);
    }

}
