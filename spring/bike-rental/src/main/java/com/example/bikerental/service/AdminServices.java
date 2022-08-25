package com.example.bikerental.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bikerental.model.BikeModel;
import com.example.bikerental.model.Booking;
import com.example.bikerental.model.Comments;
import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.repository.BikeRepository;
import com.example.bikerental.repository.BookingRepository;
import com.example.bikerental.repository.CommentRepository;
import com.example.bikerental.repository.CustomerRepository;
import com.example.bikerental.repository.RenterRepository;

@Service
public class AdminServices {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RenterRepository renterRepository;
    @Autowired
    BikeRepository bikeRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CommentRepository commentRepository;

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
}
