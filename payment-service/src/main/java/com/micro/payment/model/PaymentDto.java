package com.micro.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	private Long userId;
	private String modeOfPayment;
	private String status;
	private Long cartId;
	private String name;
	private String phone;
	private String address;
	private String city;
	private String country;
	private String creditCard;
	private String cvv;
	private String expirationDate;
}
