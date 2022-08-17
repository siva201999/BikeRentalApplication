package com.example.bikerental.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.bikerental.model.AdminModel;
import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.repository.AdminRepository;
import com.example.bikerental.repository.CustomerRepository;
import com.example.bikerental.repository.RenterRepository;

@Service
public class AuthService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    RenterRepository renterRepository;
    @Autowired
    CustomerRepository customerRepository;
    //==================================SIGN-UP=========================
    //============================Renter================================
    public RenterModel setCurrentRenter(RenterModel data){
        List<RenterModel> renters=renterRepository.findAll();
        for(RenterModel renter:renters){
            if(renter.getEmail().equals(data.getEmail())){
                return renter;
            }
        }
        return null;
    }

    public RenterModel saveRenter(RenterModel data){
        RenterModel currentRenter=setCurrentRenter(data);
        if(currentRenter==null){
            return renterRepository.save(data);
        }
        return null;
    }

    //==============================Customer=================================
    public CustomerModel setCurrentCustomer(CustomerModel data){
        List<CustomerModel> customers=customerRepository.findAll();
        for(CustomerModel customer:customers){
            if(customer.getEmail().equals(data.getEmail())){
                return customer;
            }
        }
        return null;
    }

    public CustomerModel saveCustomer(CustomerModel data){
        CustomerModel currentCustomer=setCurrentCustomer(data);
        if(currentCustomer==null){
            return customerRepository.save(data);
        }
        return null;
    }

    //==================================LOGIN=======================================
    public Map<String, String> isAdminPresent(AdminModel data){
        List<AdminModel> admins = adminRepository.findAll();
        Map<String, String> result = new HashMap<String, String>();
        
        for(AdminModel admin: admins){
            if(admin.getEmail().equals(data.getEmail()) && admin.getPassword().equals(data.getPassword())){
                result.put("userId", Long.toString(admin.getId()));
                result.put("username", admin.getUserName());
                result.put("email", admin.getEmail());
                result.put("status","Success");
                break;
            }
            else{
                result.put("status", "Failure");
            }
        }
        return result;
    }

    public Map<String, Object> isRenterPresent(RenterModel data){
        List<RenterModel> renters = renterRepository.findAll();
        Map<String, Object> result = new HashMap<String, Object>();
        for(RenterModel renter:renters){
            if(renter.getEmail().equals(data.getEmail()) && renter.getPassword().equals(data.getPassword())){
                result.put("userId", renter.getId());
                result.put("username", renter.getUserName());
                result.put("email", renter.getEmail());
                result.put("role", renter.getUserRole());
                result.put("status","Success");
                result.put("active",renter.getIsActive());
                break;
            }
            else{
                result.put("status", "Failure");
            }
        }
        return result;
       
    }

    public Map<String, Object> isCustomerPresent(CustomerModel data){
        List<CustomerModel> customers = customerRepository.findAll();
        Map<String, Object> result = new HashMap<String, Object>();
        for(CustomerModel customer:customers){
            if(customer.getEmail().equals(data.getEmail()) && customer.getPassword().equals(data.getPassword())){
                result.put("userId", customer.getId());
                result.put("username", customer.getUserName());
                result.put("email", customer.getEmail());
                result.put("role", customer.getUserRole());
                result.put("status","Success");
                result.put("active",customer.getIsActive());
                break;
            }
            else{
                result.put("status", "Failure");
            }
        }
        return result;
       
    }


}
