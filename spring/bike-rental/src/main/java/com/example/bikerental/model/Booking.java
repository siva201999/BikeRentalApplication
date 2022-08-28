package com.example.bikerental.model;

import java.time.LocalDate ;

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
    private LocalDate bookingDate;
    private LocalDate endDate;
    private String renterName;
    private String customerName;
    private String brandName;
    private String modelName;
   
    
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
    public LocalDate  getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDate  bookingDate) {
        this.bookingDate = bookingDate;
    }
    public LocalDate  getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate  endDate) {
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

    public RenterModel getRenter() {
        return renter;
    }

    public void setRenter(RenterModel renter) {
        this.renter = renter;
    }

    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Booking(CustomerModel customer) {
        super();
        this. customer =  customer;
    }

    public Booking(RenterModel renter) {
        super();
        this. renter =  renter;
    }

    public Booking(Double totalAmount, LocalDate  bookingDate, LocalDate  endDate, String renterName,String customerName,String brandName,String modelName) {
        
        this.totalAmount = totalAmount;
        this.bookingDate = bookingDate;
        this.endDate = endDate;
        this.renterName = renterName;
        this.customerName = customerName;
        this.brandName = brandName;
        this.modelName = modelName;
    }

    public Booking() {
    }

    @Override
    public String toString() {
        return "Booking [booking_id=" + booking_id + ", totalAmount=" + totalAmount + ", bookingDate=" + bookingDate
        + ", endDate=" + endDate + ", renterName=" + renterName + ", customerName=" + customerName
        + ", customer=" + customer + ", renter=" + renter + "]";
    }
   
    
    

   
    
    
    
}
