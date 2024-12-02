package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.Booking;
import com.smokedcorn.trainerbot.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {

        this.bookingRepository = bookingRepository;
    }


    // 로그인한 사용자의 예약 조회
    public List<Booking> getBookingById(String userId) {
        return bookingRepository.findByUserUserIdAndDeletedAtIsNull(userId);
    }

    // 예약 추가
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }


    // 예약 삭제
    public void deleteBooking(String userId, String bookingId) {
        bookingRepository.softDeleteBooking(userId, bookingId);
    }
}
