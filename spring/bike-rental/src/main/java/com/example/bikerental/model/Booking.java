package com.example.bikerental.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String customerName;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	@JoinColumn(nullable = false, name = "customer_id")
	private CustomerModel customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	@JoinColumn(nullable = false, name = "renter_id")
	private RenterModel renter;
    
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
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerModel getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public Booking(CustomerModel customer) {
		super();
		this. customer =  customer;
	}

    public Booking(Double totalAmount, Date bookingDate, Date endDate, String renterName,String customerName) {
        // this.booking_id = booking_id;
        this.totalAmount = totalAmount;
        this.bookingDate = bookingDate;
        this.endDate = endDate;
        this.renterName = renterName;
        this.customerName = customerName;
    }
    public Booking() {
    }
    
    

   
    
    
    
}
