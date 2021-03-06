//package com.zee.zee5app.dto;
//
//import java.math.BigDecimal;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//
//@Entity
//@Table(name = "login")
//public class Login implements Comparable<Login>{
//	
//	@Id
//	@Column(name = "username")
//	private String userName;
//	
//	private String password;
//	private String regId;
//	//private ROLE role;
//	//private Role role;
//	
//
//	@Override
//	public int compareTo(Login o) {
//		// TODO Auto-generated method stub
//		return this.regId.compareTo(o.getRegId());
//	}
//	
////	@OneToOne(fetch = FetchType.LAZY)
//////	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
////    @JoinColumn(name = "regId")
////	private Register register;
////	@OneToOne
////	@JoinColumn(name = "regId")
////	private Register register;
// 
//
//}


package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "login")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "userName")

public class Login implements Comparable<Login>{
	
	@Id
	@Column(name = "username")
	private String userName;
    @NotBlank
	private String password;

	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub   
		return this.userName.compareTo(o.getUserName());
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "regId")
    @JsonProperty(access = Access.WRITE_ONLY)
	private User register;

}