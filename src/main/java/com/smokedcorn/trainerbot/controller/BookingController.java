package com.smokedcorn.trainerbot.controller;

import com.smokedcorn.trainerbot.controller.dto.BookingRequestDTO;
import com.smokedcorn.trainerbot.domain.Booking;
import com.smokedcorn.trainerbot.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//@CrossOrigin(origins = "http://localhost:8090")  // 요청하는 도메인 허용
@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

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
        booking.setUpdatedAt(new Date());

        // 서비스 계층 호출
        Booking createBooking = bookingService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBooking);
    }

    // Booking ID 생성 메서드
    private String generateBookingId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 20);
    }


    // 로그인한 사용자의 예약 조회
    @PostMapping("/getReservations")
    public ResponseEntity<?> getBookingByUserId(@RequestBody BookingRequestDTO bookingRequestDTO) {
        try {
            String userId = bookingRequestDTO.getUserId();
            if (userId == null || userId.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User ID is required");
            }

            List<Booking> bookings = bookingService.getBookingById(userId);
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving reservations: " + e.getMessage());
        }
    }


    // 예약 삭제
    @DeleteMapping("/deleteReservations")
    public ResponseEntity<String> deleteUserBooking(@RequestBody Map<String, String> request) {
        try {
            System.out.println(request);
            String bookingId = request.get("id");

            if (bookingId == null || bookingId.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Booking ID is required");
            }

            bookingService.deleteBooking(bookingId);
            return ResponseEntity.ok("Reservation deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Failed to delete reservation: " + e.getMessage());
        }
    }
}





