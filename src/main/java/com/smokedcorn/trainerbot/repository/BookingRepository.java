package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    // 삭제되지 않은 특정 사용자의 예약 조회
    @Query("SELECT b FROM Booking b WHERE b.userId = :userId AND b.deletedAt IS NULL")
    List<Booking> findByUserUserIdAndDeletedAtIsNull(@Param("userId") String userId);


    // bookingId로만 soft delete 수행
    @Modifying
    @Transactional
    @Query("UPDATE Booking b SET b.deletedAt = CURRENT_TIMESTAMP WHERE b.bookingId = :bookingId AND b.deletedAt IS NULL")
    void softDeleteBooking(@Param("bookingId") String bookingId);
}
