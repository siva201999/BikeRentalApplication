package com.example.bikerental.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bikerental.model.AdminModel;
import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.PasswordDecrypt;
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

    //========================update customer password========================================
    @PostMapping("customer/oldPassword/{id}")
    public boolean customerPasswordDecrypt(@PathVariable("id")Long id, @RequestBody PasswordDecrypt oldPassword){
        return authService.customerPasswordDecrypt(id, oldPassword);
    }

    @PutMapping("/customer/updatePassword/{id}")
    public ResponseEntity<CustomerModel> updateCustomerPassword(@PathVariable("id")Long id, @RequestBody CustomerModel customer){
        return authService.updateCustomerPassword(id, customer);
    }


    //========================update renter password========================================
    @PostMapping("renter/oldPassword/{id}")
    public boolean renterPasswordDecrypt(@PathVariable("id")Long id, @RequestBody PasswordDecrypt oldPassword){
        return authService.renterPasswordDecrypt(id, oldPassword);
    }

    @PutMapping("/renter/updatePassword/{id}")
    public ResponseEntity<RenterModel> updaterenterPassword(@PathVariable("id")Long id, @RequestBody RenterModel renter){
        return authService.updateRenterPassword(id, renter);
    }
}
