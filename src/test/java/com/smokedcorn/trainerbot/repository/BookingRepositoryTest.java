package com.smokedcorn.trainerbot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookingRepositoryTest {

    @Autowired
    BookingRepository bookingRepository;


    @Test
    void 예약_삭제() {
        bookingRepository.softDeleteBooking("0c0b95d8f793443fbb89");

//        Assertions.assertThat(savedUser.getUserId()).isEqualTo("test");

    }


}