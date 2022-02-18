package com.learning.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	//custom jpa metod //we will not write any defination //just only signature
	Boolean existsByEmail(String email);
	Boolean existsByUserName(String userName);
	Optional<User> findByUserName(String userName);
}
