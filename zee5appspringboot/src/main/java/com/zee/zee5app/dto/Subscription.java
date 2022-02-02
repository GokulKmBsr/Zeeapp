package com.zee.zee5app.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString

@Entity //entity class is used for ORM 
//can we custamize the table name
@Table(name = "subscription")
@AllArgsConstructor
public class Subscription implements Comparable<Subscription>{
	
//	public Subscription(){
//		
//	}

//	public Subscription(String id, String dateOfPurchase, String exprirydate, float amount, String paymentmode,
//			String status, String type, String autorenewal, String regId) throws InvalidIdLengthException, InvalidAmountException {
//		super();
//		this.setId(id);
//		this.setDateOfPurchase(dateOfPurchase);
//		this.setExpiryDate(expiryDate);
//		this.setAmount(amount);
//		this.setPaymentMode(paymentMode);
//		this.setStatus(status);
//		this.setType(type);
//		this.setRegId(regId);
//		this.setAutoRenewal(autoRenewal);
//	}

	@Id
	//@Setter(value = AccessLevel.NONE)
	private String id;
	@NotBlank
	private String type;
	@NotNull
    private Date dateOfPurchase;
	@NotBlank
    private String paymentMode;
    @NotNull
    private float amount;
    @NotBlank
    private String status;
    @NotBlank
    private String autoRenewal;
    @NotNull
    private Date expiryDate;
    @NotBlank
    private String regId;



	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

//	public void setId(String id) throws InvalidIdLengthException {
//		if(id.length()<6)
//			throw new InvalidIdLengthException("Id length cannot be less than 6");
//		this.id = id;
//
//	}
//
//	public void setAmount(float amount) throws InvalidAmountException {
//		if(amount < 1000.00)
//			throw new InvalidAmountException("Amount cannot be less than 1000");
//		this.amount = amount;
//	}

	


}