package com.micro.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.payment.entity.Payment;
import com.micro.payment.model.PaymentDto;
import com.micro.payment.repository.PaymentRepository;
import com.micro.payment.utility.PaymentUtility;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment addPayment(PaymentDto paymentDto) {
		return paymentRepository.save(new PaymentUtility().convert(paymentDto));
	}
}
