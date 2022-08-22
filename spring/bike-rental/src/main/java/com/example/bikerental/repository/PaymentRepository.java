package com.example.bikerental.repository;

import com.example.bikerental.model.PaymentModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Long>{

	
//	boolean existsBycardType(String cardType);
//	boolean existsByexpiryMM(int expiryMM);
//	boolean existsByexpiryYY(int expiryYY);
//	boolean existsBycvv(int cvv);
//	boolean existsByname(String name);
	
	PaymentModel findByCardNumber(long cardNumber);
}
