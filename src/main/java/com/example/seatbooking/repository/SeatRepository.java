package com.example.seatbooking.repository;

import com.example.seatbooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByIsBooked(boolean isBooked);
}
