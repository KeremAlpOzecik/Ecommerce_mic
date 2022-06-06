package com.micro.payment.service;

import com.micro.payment.entity.Payment;
import com.micro.payment.model.PaymentDto;

public interface PaymentService {

	public Payment addPayment(PaymentDto paymentDto);

}
