package com.micro.payment.utility;

import com.micro.payment.entity.Payment;
import com.micro.payment.model.PaymentDto;

public interface Converter {
   public Payment convert(PaymentDto paymentDto);
}