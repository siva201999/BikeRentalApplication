package com.example.bikerental.service;

import java.util.Optional;

import com.example.bikerental.model.Booking;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.repository.BookingRepository;
import com.example.bikerental.repository.RenterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookingService  {
	
	@Autowired
	BookingRepository bookingRepository;
	RenterRepository renterRepository;

	public ResponseEntity<?> addBookingHistory(long id, Booking booking) {

		return new ResponseEntity<>(bookingRepository.save(booking), HttpStatus.OK);
	}

	public ResponseEntity<?> deleteBookingById(long id) {
		try {
			if(bookingRepository.findById(id).isPresent()) {
				bookingRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			}
			catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			    }		
	}


	

}
