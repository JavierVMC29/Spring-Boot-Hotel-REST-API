package com.hotel.api.repository;

import com.hotel.api.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
