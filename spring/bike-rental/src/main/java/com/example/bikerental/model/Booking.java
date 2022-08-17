package com.example.bikerental.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long booking_id;
    private Double totalAmount;
    private Date bookingDate;
    private Date endDate;
    private String renterName;
    public Long getBooking_id() {
        return booking_id;
    }
    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Date getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getRenterName() {
        return renterName;
    }
    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }
    public Booking(Long booking_id, Double totalAmount, Date bookingDate, Date endDate, String renterName) {
        this.booking_id = booking_id;
        this.totalAmount = totalAmount;
        this.bookingDate = bookingDate;
        this.endDate = endDate;
        this.renterName = renterName;
    }
    public Booking() {
    }
    
    
}
