package com.example.bikerental.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.bikerental.model.RenterModel;
import com.example.bikerental.service.RenterService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RenterController {
	@Autowired
	private RenterService renterService;
	
	 @GetMapping("/renterEarning/{renterId}")
	    public double getRenterEarning(@PathVariable Long renterId){
	        return renterService.getRenterEarning(renterId);
	    }
	 
	 @GetMapping("/renterDetail/{renterId}")
	    public ResponseEntity<RenterModel> getRenterById(@PathVariable Long renterId){
	        return renterService.getRenterById(renterId);
	    }
	 
	 @PutMapping("/renterProfile/{id}")
		public ResponseEntity<?> updateProfile(@PathVariable("id")long id,@RequestBody RenterModel renter){
			return renterService.updateProfile(id,renter);
		}
}