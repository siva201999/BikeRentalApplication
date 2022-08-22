package com.example.bikerental.controller;

import com.example.bikerental.model.PaymentModel;
import com.example.bikerental.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PaymentController {

	 @Autowired
		private PaymentService paymentService;

		//getAllBikes

	 	@PostMapping("/")
		public ResponseEntity<PaymentModel> saveBookingHistory(@RequestBody PaymentModel paymentModel){
	 		return paymentService.saveBookingHistory(paymentModel);
	 	}
}
