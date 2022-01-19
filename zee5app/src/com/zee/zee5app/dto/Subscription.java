package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Subscription {
	private String type;
	private String id;
	private String email;
	private String dateofpurcahse;
	private String status;
	private String paymentmode;
	private String packCountry;
	private String autoRenewal;
	private String expiryDate;
	
}
