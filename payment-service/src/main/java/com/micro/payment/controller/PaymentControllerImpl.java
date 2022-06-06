package com.micro.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.micro.payment.entity.Payment;
import com.micro.payment.model.PaymentDto;
import com.micro.payment.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PaymentControllerImpl implements PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Override
	public ResponseEntity<Payment> addPayment(PaymentDto paymentDto) {
		log.info("Adding Payment");
		Payment payment = paymentService.addPayment(paymentDto);
		return new ResponseEntity<>(payment, HttpStatus.CREATED);
	}
}
