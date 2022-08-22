package com.example.bikerental.service;

import java.util.ArrayList;
import java.util.List;

import com.example.bikerental.model.PaymentModel;
import com.example.bikerental.repository.PaymentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;




@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
    private PaymentModel paymentModel;



	public ResponseEntity<PaymentModel> saveBookingHistory(PaymentModel paymentModel) {

		return null;
	}
	
	public List<PaymentModel> getAllAccounts(){
		
		if(paymentRepository.findAll().isEmpty()) {
			return null;
		}
		else {
			List<PaymentModel> paymentList = new ArrayList<PaymentModel>();
			paymentList = paymentRepository.findAll();
			return paymentList;
		}
	}
}
