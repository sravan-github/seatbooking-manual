package com.example.seatbooking.thread;

import com.example.seatbooking.service.SeatService;

public class SeatBookingThread extends Thread {

    private final SeatService seatService;
    private final Long seatId;
    private final String username;

    public SeatBookingThread(SeatService seatService, Long seatId, String username) {
        this.seatService = seatService;
        this.seatId = seatId;
        this.username = username;
    }

    @Override
    public void run() {
        seatService.bookSeatThreadSafe(seatId, username);
    }
}
