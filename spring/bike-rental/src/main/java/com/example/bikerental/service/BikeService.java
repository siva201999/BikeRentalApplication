package com.example.bikerental.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.bikerental.model.BikeModel;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.repository.BikeRepository;
import com.example.bikerental.repository.RenterRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BikeService {

    @Autowired
	private BikeRepository bikeRepository;
	@Autowired
	private RenterRepository renterRepository;
	
//fetch all bikes
	public ResponseEntity<List<BikeModel>> getAllBikes() {
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
public ResponseEntity<?> addBikes(Long id, BikeModel bike) {
	try {
	if(bikeRepository.existsByBikeNumber(bike.getBikeNumber())) {
	return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	else if(renterRepository.findById(id).isPresent()) {
		renterRepository.findById(id).map(bikeDetail->
		bikeDetail.getBike().add(bike));
		return new ResponseEntity<>(bikeRepository.save(bike),HttpStatus.OK);
	}
	else {
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	 }
	catch (Exception e) {
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	}
	//edit bikes
	public ResponseEntity<?> updateBike(Long id, BikeModel bike) {
		try {
            if(bikeRepository.findById(id).isPresent()) {
                BikeModel editBike=bikeRepository.getReferenceById(id);
                editBike.setBikeNumber(bike.getBikeNumber());
                editBike.setBrandName(bike.getBrandName());
                editBike.setModelName(bike.getModelName());
                editBike.setPickUpLocation(bike.getPickUpLocation());
                editBike.setRentAmount(bike.getRentAmount());
                editBike.setAvailability(bike.getAvailability());
    //			editBike.setBikeImage(bike.getBikeImage());
                editBike.setBikeImage(bike.getBikeImage());
                editBike.setDescription(bike.getDescription());
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

	public ResponseEntity<BikeModel> getBikeById(Long id) {
		try {
			if(bikeRepository.findById(id).isPresent()) {	
				return new ResponseEntity<>(bikeRepository.getReferenceById(id),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }	
    }

 //get renter bike by id

	public Set<BikeModel> getRenterBikes(Set<BikeModel> set){
        return set;
    }

    public Set<BikeModel> getRenterById(Long id){
        Optional<RenterModel> renter=renterRepository.findById(id);
        // System.out.println(renter.get().toString());

        if(renter.isPresent()){
            return getRenterBikes(renter.get().getBike());
        }
        return null;
    }

}
