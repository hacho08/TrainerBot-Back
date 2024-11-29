package com.smokedcorn.trainerbot.controller;

import com.smokedcorn.trainerbot.domain.Booking;
import com.smokedcorn.trainerbot.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a new booking
    @PostMapping("/reservations")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {

        Booking createdBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(createdBooking);
    }

//    // Get all bookings
//    @GetMapping
//    public ResponseEntity<List<Booking>> getAllBookings() {
//        List<Booking> bookings = bookingService.getAllBookings();
//        return ResponseEntity.ok(bookings);
//    }
//
//    // Get a booking by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Booking> getBookingById(@PathVariable String id) {
//        Booking booking = bookingService.getBookingById(id);
//        return ResponseEntity.ok(booking);
//    }
//
//    // Update a booking
//    @PutMapping("/{id}")
//    public ResponseEntity<Booking> updateBooking(@PathVariable String id, @RequestBody Booking booking) {
//        Booking updatedBooking = bookingService.updateBooking(id, booking);
//        return ResponseEntity.ok(updatedBooking);
//    }
//
//    // Delete a booking
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBooking(@PathVariable String id) {
//        bookingService.deleteBooking(id);
//        return ResponseEntity.noContent().build();
//    }
}
