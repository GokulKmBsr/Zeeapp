package com.zee.zee5app.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Register;

@Repository
public interface UserRepository extends JpaRepository<Register, String> {
	//custom jpa metod //we will not write any defination //just onlu signature
	//Boolean existsByEmail(String email);
	//Boolean existsByContactnumber(BigDecimal contactnumber);
	Boolean existsByEmailAndContactnumber(String email,BigDecimal contactnumber);
}
