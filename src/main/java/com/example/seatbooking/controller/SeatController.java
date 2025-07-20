package com.example.seatbooking.controller;

import com.example.seatbooking.entity.Seat;
import com.example.seatbooking.service.SeatService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/available")
    public List<Seat> getAvailableSeats() {
        return seatService.getAvailableSeats();
    }

    @PostMapping("/add")
    public Seat addSeat(@RequestParam int seatNumber) {
        return seatService.addSeat(seatNumber);
    }

    @PostMapping("/book/{id}")
    public Optional<Seat> bookSeat(@PathVariable Long id, @RequestParam String username) {
        return seatService.bookSeat(id, username);
    }

    @PostMapping("/cancel/{id}")
    public Optional<Seat> cancelSeat(@PathVariable Long id) {
        return seatService.cancelBooking(id);
    }

    @DeleteMapping("/{id}")
public ResponseEntity<String> deleteSeat(@PathVariable Long id) {
    seatService.deleteSeat(id);
    return ResponseEntity.ok("Seat deleted successfully");
    }
    
}
