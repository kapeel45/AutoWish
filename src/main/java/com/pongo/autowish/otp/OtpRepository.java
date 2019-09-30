package com.pongo.autowish.otp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long>{

	Optional<Otp> findByOtp(String otp);
}
