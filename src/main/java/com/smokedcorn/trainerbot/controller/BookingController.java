package com.smokedcorn.trainerbot.controller;

import com.smokedcorn.trainerbot.controller.dto.BookingRequestDTO;
import com.smokedcorn.trainerbot.domain.Booking;
import com.smokedcorn.trainerbot.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

//@CrossOrigin(origins = "http://localhost:8090")  // 요청하는 도메인 허용
@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/reservations")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        // DTO에서 Booking 엔터티로 변환
        Booking booking = new Booking();
        booking.setBookingId(generateBookingId()); // 자동으로 ID 생성
        booking.setUserId(bookingRequestDTO.getUserId()); // userId 설정
        booking.setBookingDate(bookingRequestDTO.getBookingDate()); // bookingDate 설정
        booking.setCreatedAt(new Date()); // 생성 시간 설정

        // 서비스 계층 호출
        Booking createBooking = bookingService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBooking);
    }

    // Booking ID 생성 메서드
    private String generateBookingId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 20);
    }
}


//    // 로그인한 사용자의 예약 조회
//    @PostMapping("/getReservations")
//    public List<Booking> getUserBookings(Principal principal) {
//        // 현재 로그인한 사용자의 ID를 가져옵니다.
//        String userId = principal.getName();
//
////        // 서비스 계층 호출하여 예약 정보 조회
////        return bookingService.getBookingById(userId);
////    }
//
//
//
////    // Get all bookings
////    @GetMapping
////    public ResponseEntity<List<Booking>> getAllBookings() {
////        List<Booking> bookings = bookingService.getAllBookings();
////        return ResponseEntity.ok(bookings);
////    }
////
////    // Get a booking by ID
////    @GetMapping("/{id}")
////    public ResponseEntity<Booking> getBookingById(@PathVariable String id) {
////        Booking booking = bookingService.getBookingById(id);
////        return ResponseEntity.ok(booking);
////    }
////
////    // Update a booking
////    @PutMapping("/{id}")
////    public ResponseEntity<Booking> updateBooking(@PathVariable String id, @RequestBody Booking booking) {
////        Booking updatedBooking = bookingService.updateBooking(id, booking);
////        return ResponseEntity.ok(updatedBooking);
////    }
////
////    // Delete a booking
////    @DeleteMapping("/{id}")
////    public ResponseEntity<Void> deleteBooking(@PathVariable String id) {
////        bookingService.deleteBooking(id);
////        return ResponseEntity.noContent().build();
////    }
//
//}