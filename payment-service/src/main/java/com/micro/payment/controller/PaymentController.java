package com.micro.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.micro.payment.entity.Payment;
import com.micro.payment.model.PaymentDto;

@RequestMapping("/v1/api")
public interface PaymentController {

	@PostMapping("/payments")
	public ResponseEntity<Payment> addPayment(PaymentDto paymentDto);

}
