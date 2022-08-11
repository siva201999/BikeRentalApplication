package com.example.bikerental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    public List<RenterModel> getRenters(String email){
        List<RenterModel> renters=getAllRenters();
        List<RenterModel> renterBikes=new ArrayList<>();
        for(RenterModel renter:renters){
            if(renter.getEmail().equals(email)){
                renterBikes.add(renter);
            }
        }
        return renterBikes;
    }

    public List<BikeModel> getRenterBikes(RenterModel renter){
        List<BikeModel> bikes=bikeRepository.findAll();
        List<RenterModel> renters=getRenters(renter.getEmail());
        List<BikeModel> renterBikes=new ArrayList<BikeModel>();
        for(RenterModel renterList:renters){
            for(BikeModel bike:bikes){
                    if(bike.getId().equals(renterList.getId())){
                        renterBikes.add(bike);
                }
            }
        }
        return renterBikes;
    }

    public List<BikeModel> getRenterById(Long id){
        Optional<RenterModel> renter=renterRepository.findById(id);
        // System.out.println(renter.get().toString());

        if(renter.isPresent()){
            return getRenterBikes(renter.get());
        }
        return null;
    }

    public RenterModel isRenterActive(Long id){
        RenterModel renter=renterRepository.findById(id).get();
        if(!renter.getIsActive().equals("false")){
            renter.setIsActive("false");
            renter=renterRepository.save(renter);
            return renter ;
        }
        return null;
    }

    public CustomerModel isCustomerActive(Long id){
        CustomerModel customer=customerRepository.findById(id).get();
        if(!customer.getIsActive().equals("false")){
            customer.setIsActive("false");
            customer=customerRepository.save(customer);
            return customer;
        }
        return null;
    }

    

    
}
