package com.example.seatbooking.service;

import com.example.seatbooking.entity.Seat;
import com.example.seatbooking.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public List<Seat> getAvailableSeats() {
        return seatRepository.findByIsBooked(false);
    }

    public Seat addSeat(int seatNumber) {
        Seat seat = new Seat();
        seat.setSeatNumber(seatNumber);
        seat.setBooked(false);
        return seatRepository.save(seat);
    }

    public Optional<Seat> bookSeat(Long id, String username) {
        Optional<Seat> seatOptional = seatRepository.findById(id);
        seatOptional.ifPresent(seat -> {
            if (!seat.isBooked()) {
                seat.setBooked(true);
                seat.setBookedBy(username);
                seatRepository.save(seat);
            }
        });
        return seatOptional;
    }

    public Optional<Seat> cancelBooking(Long id) {
        Optional<Seat> seatOptional = seatRepository.findById(id);
        seatOptional.ifPresent(seat -> {
            if (seat.isBooked()) {
                seat.setBooked(false);
                seat.setBookedBy(null);
                seatRepository.save(seat);
            }
        });
        return seatOptional;
    }
    public void deleteSeat(Long id) {
    seatRepository.deleteById(id);
    }
}
