package com.pongo.autowish.user;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pongo.autowish.otp.OtpRepository;

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OtpRepository otpRepo;
	

	public User addUser(User user) {

		try {
			return userRepo.save(user);
		} catch (Exception e) {
			log.error("Exception:: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(String id) {
		try {
			Optional<User> user = userRepo.findById(Long.parseLong(id));

			if (user.isPresent()) {
				log.info("Document found :: carId: " + user.get().getUserId());
				return user.get();
			} else {
				log.error("No such document found error:: carId:" + id);
			}
		} catch (Exception e) {
			log.error("Exception :: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getAllUser() {
		try {
			List<User> lstUser = userRepo.findAll();

			if (!lstUser.isEmpty()) {
				log.info("All document found");
				return lstUser;
			}
		} catch (Exception e) {
			log.error("Exception:: " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	public User findByMobile(String mobileNumber) {
		
		Optional<User> user = userRepo.findByMobile(mobileNumber);
		
		try{
			if(user.isPresent()) {
				return user.get();
			}else {
				log.error("User with mobile number:: "+mobileNumber+ " not found");
			}
		}catch(Exception e) {
			log.error("Exception:: "+e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean verifyMobile(String otp) {
		
		otpRepo.findByOtp(otp);
		return false;
	}
}
