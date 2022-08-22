package com.example.bikerental.service;

import com.example.bikerental.model.Booking;
import com.example.bikerental.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookingService  {
	
	@Autowired
	BookingRepository bookingRepository;

	public ResponseEntity<?> addBookingHistory(long id, Booking booking) {

		return new ResponseEntity<>(bookingRepository.save(booking), HttpStatus.OK);
	}

}
