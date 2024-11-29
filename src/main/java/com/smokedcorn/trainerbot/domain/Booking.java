package com.smokedcorn.trainerbot.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="BOOKING")
public class Booking {

    @Id
    @Column(name = "BOOKING_ID", nullable = false, length = 20)
    private String bookingId;

    @Column(name = "BOOKING_DATE")
    private Date bookingDate;

    @Column(name = "DELETED_AT")
    private Date deletedAt;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;


    @Column(name = "USER_ID", nullable = false)
    private String userId;  // USER_ID와 연결 (User 엔티티와 다대일 관계)


    // 기본 생성자
    public Booking() {}

    // 전체 필드를 받는 생성자
    public Booking(String bookingId, Date bookingDate, Date deletedAt, Date createdAt, Date updatedAt) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.deletedAt = deletedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter and Setter methods
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String user) {
        this.userId = user;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // toString(), equals(), hashCode() 등의 메서드도 필요에 따라 추가할 수 있습니다.
}

