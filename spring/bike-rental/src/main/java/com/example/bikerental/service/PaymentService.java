package com.example.bikerental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

		List<PaymentModel> paymentList = new ArrayList<PaymentModel>();
		paymentList = getAllAccounts();

		
			PaymentModel p = paymentRepository.findByCardNumber(paymentModel.getCardNumber());
			if (Objects.isNull(p)) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		
			else {
		    if(p.getCardNumber() == paymentModel.getCardNumber() &&
		    	   p.getCardType().equals(paymentModel.getCardType())&&
				   p.getExpiryMM() == paymentModel.getExpiryMM() &&
				   p.getExpiryYY() == paymentModel.getExpiryYY() &&
				   p.getName().equals(paymentModel.getName())&&
				   p.getCvv() == paymentModel.getCvv()
				   )
				
					{
				      return new ResponseEntity<>(HttpStatus.OK);
					}
			else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
			}
		

		
 

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
