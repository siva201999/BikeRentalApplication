package com.example.bikerental.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.model.BikeModel;
import com.example.bikerental.model.Booking;
import com.example.bikerental.model.Comments;
import com.example.bikerental.service.AdminServices;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {

    @Autowired
    AdminServices adminServices;
    

    @GetMapping("/customers")
    public List<CustomerModel> getAllCustomers() {
        return adminServices.getAllCustomers();
    }
    
    @GetMapping("/renters")
    public List<RenterModel> getAllRenters(){
        return adminServices.getAllRenters();
    }

    @GetMapping("/renters/{renterId}")
    public Set<BikeModel> getRenterById(@PathVariable Long renterId){
        return adminServices.getRenterById(renterId);
    }
    
    @PutMapping("/renters/{id}")
    public RenterModel isRenterActive(@PathVariable Long id){
        return adminServices.isRenterActive(id);
    }

    @PutMapping("/customers/{id}")
    public CustomerModel isCustomerActive(@PathVariable Long id){
        return adminServices.isCustomerActive(id);
    }

    @GetMapping("/customer/bookings")
    public List<Booking> getAllBookings(){
        return adminServices.getAllBookings();
    }

    @GetMapping("/feedback")
    public List<Comments> getAllComments(){
        return adminServices.getAllComments();
    }
}
