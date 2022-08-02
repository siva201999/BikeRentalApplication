package com.example.bikerentalapplication.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bikerentalapplication.entity.Bike;
import com.example.bikerentalapplication.service.BikeService;

@RestController
public class BikeController {
	@Autowired
	private BikeService bikeService;
	//getAllBikes
	@GetMapping("/bike")
	public ResponseEntity<List<Bike>> getAllBikes(){
		return bikeService.getAllBikes();
	}
	@PostMapping("/bike")
	public ResponseEntity<?> addBikes(@RequestBody Bike bike){
		//System.out.println(bike.getBikeId());
		return bikeService.addBikes(bike);
	}
	@PutMapping("/bike/{id}")
	public ResponseEntity<?> updateBikes(@PathVariable("id")long id,@RequestBody Bike bike){
		return bikeService.updateBike(id,bike);
	}
	@DeleteMapping("/bike/{id}")
	public ResponseEntity<?> deleteBikeById(@PathVariable("id")long id){
		return bikeService.deleteBikeById(id);
	}
	
}
