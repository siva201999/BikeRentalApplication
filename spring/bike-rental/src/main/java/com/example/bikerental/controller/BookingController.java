package com.example.bikerental.controller;

import com.example.bikerental.model.Booking;
import com.example.bikerental.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController

@CrossOrigin(origins="http://localhost:4200")
public class BookingController {

	@Autowired
	BookingService bookingService;
    @PostMapping("/booking/{id}")
	public ResponseEntity<?> addBookingHistory(@PathVariable("id")long id, @RequestBody Booking booking){
	return bookingService.addBookingHistory(id,booking);
	}
}
