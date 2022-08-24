package com.example.bikerental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bikerental.model.Comments;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.repository.CommentRepository;
import com.example.bikerental.repository.RenterRepository;

@Service
public class RenterService {
	@Autowired
	private RenterRepository renterRepository;
	@Autowired
	private CommentRepository commentRepository;
	//Get Renter Earninngs
	public double getRenterEarning(Long renterId) {
		return renterRepository.getReferenceById(renterId).getEarnings();
	}
	
	// Get Renter By Id
	public ResponseEntity<RenterModel> getRenterById(Long renterId) {
		try {
			if(renterRepository.findById(renterId).isPresent()) {
				return new ResponseEntity<>(renterRepository.getReferenceById(renterId),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }	
	}

	//edit profile
	public ResponseEntity<?> updateProfile(long id, RenterModel renter) {
		try {
            if(renterRepository.findById(id).isPresent()) {
                RenterModel editRenter=renterRepository.getReferenceById(id);
               // editRenter.setEmail(renter.getEmail());
                editRenter.setMobileNumber(renter.getMobileNumber());
                editRenter.setUserName(renter.getUserName());
                editRenter.setGender(renter.getGender());
                editRenter.setImage(renter.getImage());
                editRenter.setAddress(renter.getAddress());
                return new ResponseEntity<>(renterRepository.save(editRenter), HttpStatus.OK);
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