package com.hotel.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReservationsResponse {
    private List<ReservationDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
