package com.example.bikerental.controller;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bikerental.model.BikeModel;
import com.example.bikerental.service.BikeService;

@RestController

@CrossOrigin(origins="http://localhost:4200")
public class BikeController {
    @Autowired
	private BikeService bikeService;

	//getAllBikes
	@GetMapping
	public ResponseEntity<List<BikeModel>> getAllBikes(){
		return bikeService.getAllBikes();
	}
	@PostMapping("/bike/{id}")
	public ResponseEntity<?> addBikes(@PathVariable("id")long id, @RequestBody BikeModel bike){
	//System.out.println(bike.getBikeId());
	return bikeService.addBikes(id,bike);
	}
	@PutMapping("/bike/{id}")
	public ResponseEntity<?> updateBikes(@PathVariable("id")long id,@RequestBody BikeModel bike){
		return bikeService.updateBike(id,bike);
	}
	@DeleteMapping("/bike/{id}")
	public ResponseEntity<?> deleteBikeById(@PathVariable("id")long id){
		return bikeService.deleteBikeById(id);
	}
	@GetMapping("/bike/{id}")
	public ResponseEntity<BikeModel> getBikeById(@PathVariable("id")Long id){
		return bikeService.getBikeById(id);
	}

	@GetMapping("/renter/{renterId}")
    public List<BikeModel> getRenterById(@PathVariable Long renterId){
        return bikeService.getRenterById(renterId);
    }
}
