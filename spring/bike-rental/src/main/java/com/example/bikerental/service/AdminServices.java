package com.example.bikerental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bikerental.model.BikeModel;
import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.repository.BikeRepository;
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

    public List<CustomerModel> getAllCustomers(){
        return customerRepository.findAll();
    }

    public List<RenterModel> getAllRenters(){
        return renterRepository.findAll();
    }

  

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

    

    
}
