package com.example.bikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bikerental.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    
}
