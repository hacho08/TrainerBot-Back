package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {

//    // 특정 사용자의 예약을 조회
//    List<Booking> findByUserUserId(String userId);
//
//    // 특정 날짜에 예약된 목록 조회
//    List<Booking> findByBookingDate(Date bookingDate);
//
//    // 특정 예약 ID로 예약 정보 조회
//    Optional<Booking> findByBookingId(String bookingId);
//
//    // 예약이 삭제된 상태인지 확인 (deletedAt이 null이 아닌 경우)
//    List<Booking> findByDeletedAtIsNotNull();


}
