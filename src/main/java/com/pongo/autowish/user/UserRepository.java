package com.pongo.autowish.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByMobile(String mobile);
	
	Optional<User> findByEmail(String emailId);

}
