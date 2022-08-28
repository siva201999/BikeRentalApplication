package com.example.bikerental.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bikerental.model.BikeModel;
import com.example.bikerental.model.Booking;
import com.example.bikerental.model.Comments;
import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.repository.AdminRepository;
import com.example.bikerental.repository.CommentRepository;
import com.example.bikerental.repository.CustomerRepository;
import com.example.bikerental.repository.RenterRepository;

@Service
public class AdminServices {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RenterRepository renterRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private AdminRepository adminRepository;

    //==========Fetch all customers====================
    public List<CustomerModel> getAllCustomers(){
        return customerRepository.findAll();
    }

    //===========Fetch all renters======================
    public List<RenterModel> getAllRenters(){
        return renterRepository.findAll();
    }

    //===========Fetch renter bikes======================
    // public Set<BikeModel> getRenterBikes(Set<BikeModel> bike){
    //     return bike;
    // }

    public List<BikeModel> getRenterById(Long id){
        Optional<RenterModel> renter=renterRepository.findById(id);
        if(renter.isPresent()){
            return renter.get().getBike();
        }
        return null;
    }


    //============Check if renter is active or not=================
    public RenterModel isRenterActive(Long id){
        RenterModel renter=renterRepository.findById(id).get();
        if(!renter.getIsActive().equals("false")){
            renter.setIsActive("false");
            renter=renterRepository.save(renter);
            
        }
        else if(!renter.getIsActive().equals("true")){
            renter.setIsActive("true");
            renter=renterRepository.save(renter);
        }
        return renter;
    }

    //============Check if customer is active or not=================
    public CustomerModel isCustomerActive(Long id){
        CustomerModel customer=customerRepository.findById(id).get();
        if(!customer.getIsActive().equals("false")){
            customer.setIsActive("false");
            customer=customerRepository.save(customer);
            
        }
        else if(!customer.getIsActive().equals("true")){
            customer.setIsActive("true");
            customer=customerRepository.save(customer);
            
        }
        return customer;
    }

    
    //========================getFeedback===========================
    public List<Comments> getAllComments(){
        return commentRepository.findAll();
    }

    //========================Get Admin Earninngs========================
	public double getAdminEarning(Long adminId) {
		return adminRepository.getReferenceById(adminId).getEarnings();
	}


    public ResponseEntity<Double> calculateRevenue(LocalDate startDate, LocalDate endDate) {
		Double revenue=0.0;
		List<RenterModel> renter=renterRepository.findAll();
        if(!renter.isEmpty()) {
            for(int i=0;i<renter.size();i++) {
                List<Booking> bookings=renter.get(i).getBooking();
                for(int j=0;j<bookings.size();j++) {
                    if((startDate.isBefore(bookings.get(j).getEndDate()) || startDate.isEqual(bookings.get(j).getEndDate())) && (endDate.isAfter(bookings.get(j).getEndDate()) || endDate.isEqual(bookings.get(j).getEndDate()))) {
                        revenue+=(bookings.get(j).getTotalAmount()*0.1);
                        
                    }
			}
		}
    }
		return new ResponseEntity<>(revenue, HttpStatus.OK);
	    }
}
