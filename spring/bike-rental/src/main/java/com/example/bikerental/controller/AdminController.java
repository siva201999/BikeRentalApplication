package com.example.bikerental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.model.BikeModel;
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
    public List<BikeModel> getRenterById(@PathVariable Long renterId){
        return adminServices.getRenterById(renterId);
    }
    
}
