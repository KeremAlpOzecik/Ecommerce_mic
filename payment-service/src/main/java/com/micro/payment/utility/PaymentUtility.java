package com.micro.payment.utility;

import com.micro.payment.entity.Payment;
import com.micro.payment.model.PaymentDto;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;

public class PaymentUtility implements Converter{
	JMapper<Payment,PaymentDto> jMapper;

	public PaymentUtility() {
		JMapperAPI api = new JMapperAPI()
				.add(JMapperAPI.mappedClass(Payment.class));
		
		jMapper = new JMapper<>(Payment.class, PaymentDto.class, api);
	}

	@Override
	public Payment convert(PaymentDto paymentDto) {
		return jMapper.getDestination(paymentDto);
	}
}
