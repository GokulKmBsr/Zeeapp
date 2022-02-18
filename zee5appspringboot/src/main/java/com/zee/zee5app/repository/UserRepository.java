package com.zee.zee5app.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	//custom jpa metod //we will not write any defination //just onlu signature
	//Boolean existsByEmail(String email);
	//Boolean existsByContactnumber(BigDecimal contactnumber);
	//Boolean existsByEmailAndContactnumber(String email,BigDecimal contactnumber);

	//Boolean existsByEmailAndContactnumber(String email, BigInteger contactnumber);
	
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
