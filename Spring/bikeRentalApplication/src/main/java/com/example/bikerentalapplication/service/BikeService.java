package com.example.bikerentalapplication.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bikerentalapplication.entity.Bike;
import com.example.bikerentalapplication.repository.BikeRepository;

@Service
public class BikeService {
	@Autowired
	private BikeRepository bikeRepository;
	
//fetch all bikes
	public ResponseEntity<List<Bike>> getAllBikes() {
		try {
			if(bikeRepository.findAll().isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(bikeRepository.findAll() , HttpStatus.OK);
			}
		}
		catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
//adding new bikes
	public ResponseEntity<?> addBikes(Bike bike) {
		try {
			if(bikeRepository.existsByBikeNumber(bike.getBikeNumber())) {
				 return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			else
			   return new ResponseEntity<>(bikeRepository.save(bike),HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
	}
//edit bikes
	public ResponseEntity<?> updateBike(Long id, Bike bike) {
		try {
		if(bikeRepository.findById(id).isPresent()) {
			Bike editBike=bikeRepository.getReferenceById(id);
			editBike.setBikeNumber(bike.getBikeNumber());
			editBike.setBrandName(bike.getBrandName());
			editBike.setModelName(bike.getModelName());
			editBike.setPickUpLocation(bike.getPickUpLocation());
			editBike.setRentAmount(bike.getRentAmount());
			editBike.setAvailability(bike.isAvailability());
			return new ResponseEntity<>(bikeRepository.save(editBike), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
		catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
	}

//delete bike by id
	public ResponseEntity<?> deleteBikeById(long id) {
		try {
		if(bikeRepository.findById(id).isPresent()) {
			bikeRepository.deleteById(id);
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
