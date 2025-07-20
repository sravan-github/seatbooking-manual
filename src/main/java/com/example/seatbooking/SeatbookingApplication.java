package com.example.seatbooking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.seatbooking.service.SeatService;
import com.example.seatbooking.thread.SeatBookingThread;

@SpringBootApplication
public class SeatbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeatbookingApplication.class, args);
	}

	@Bean
    public CommandLineRunner runner(SeatService seatService) {
        return args -> {
            // Simulate a new seat
            seatService.addSeat(101); // Assume seat with ID 1

            // Simulate concurrent bookings
            Thread t1 = new SeatBookingThread(seatService, 1L, "User1");
            Thread t2 = new SeatBookingThread(seatService, 1L, "User2");

            t1.start();
            t2.start();

            t1.join();
            t2.join();
			 };
    }

}
