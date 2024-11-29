package com.smokedcorn.trainerbot.controller.dto;

import java.util.Date;

public class BookingRequestDTO {
    private String userId;
    private Date bookingDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

}
