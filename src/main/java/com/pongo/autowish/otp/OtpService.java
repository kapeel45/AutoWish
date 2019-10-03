package com.pongo.autowish.otp;

import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pongo.autowish.user.User;

@Service
public class OtpService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OtpRepository otpRepo;
	
	private static final int MIN = 100000;
	private static final int MAX = 999999;
	
	public int generateOtp() {
		Random random = new Random();
	    return random.nextInt(MAX - MIN) + MIN;
	}

	public boolean verifyOtp(String otp) {
		
		try {
			Optional<Otp> otpObj =  otpRepo.findByOtp(otp);
			
			if(otpObj.isPresent()) {
				return true;
			}
		}catch(Exception e) {
			log.error("Exception :: "+e.toString());
			e.printStackTrace();
		}
		
		return false;
	}

	public Otp save(int otp, User user) {
		
		Otp otpObj = new Otp();
		
		otpObj.setOtp(""+otp); //converting to string
		otpObj.setUser(user);

		try {
			Otp otpPersist = otpRepo.save(otpObj);
			if(otpPersist != null) {
				return otpPersist;	
			}
		}catch(Exception e) {
			log.error("Exception:: "+e.toString());
			e.printStackTrace();
		}
		
		return null;
	}

	
}
