package com.example.bikerental.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bikerental.model.AdminModel;
import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.service.AuthService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/admin/login")
    public Map<String,String> isAdminPresent(@RequestBody AdminModel data){
        return authService.isAdminPresent(data);
    }

    @PostMapping("/renter/login")
    public  Map<String,Object> isRenterPresent(@RequestBody RenterModel data){
        return authService.isRenterPresent(data);
    }

    @PostMapping("/renter/signup")
    public RenterModel saveRenter(@RequestBody RenterModel data){
        return authService.saveRenter(data);
    }

    @PostMapping("/customer/login")
    public Map<String,Object> isCustomerPresent(@RequestBody CustomerModel data){
        return authService.isCustomerPresent(data);
    }

    @PostMapping("/customer/signup")
    public CustomerModel saveCustomer(@RequestBody CustomerModel data){
        return authService.saveCustomer(data);
    }

    
    
    
}
