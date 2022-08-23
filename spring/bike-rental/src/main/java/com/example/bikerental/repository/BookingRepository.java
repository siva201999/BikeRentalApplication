package com.example.bikerental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bikerental.model.Booking;



public interface BookingRepository extends JpaRepository<Booking,Long> {
    // @Query("select rt.userName,rt.id,bk.renter_id from renter rt inner join booking bk on rt.id=bk.renter_id")
    // public List<Booking> getAllBookings();
    
}
