package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.Booking;
import com.smokedcorn.trainerbot.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // 예약 조회
    public Optional<Booking> getBookingById(String bookingId) {
        return bookingRepository.findById(bookingId);
    }

    // 사용자의 모든 예약 조회
//    public List<Booking> getBookingsByUserId(String userId) {
//        return bookingRepository.findByUserUserId(userId);
//    }

    // 예약 추가
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // 예약 수정
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // 예약 삭제
    public void deleteBooking(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
