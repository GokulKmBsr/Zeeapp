package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Register;

@Repository
public interface UserRepository extends JpaRepository<Register, String> {
	//custom jpa metod //we will not write any defination //just only signature
	Boolean existsByEmail(String email);

	Boolean existsByEmailAndPassword(String email, String password);
}
