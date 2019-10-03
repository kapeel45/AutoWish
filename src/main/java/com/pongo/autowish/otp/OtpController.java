package com.pongo.autowish.otp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pongo.autowish.user.User;
import com.pongo.autowish.user.UserService;
import com.pongo.autowish.user.VerifyDto;

@RequestMapping("/otp")
@RestController
public class OtpController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OtpService otpService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/send-otp")
	public @ResponseBody ResponseEntity<Boolean> sendOtp(@RequestBody VerifyDto verifyDto){
		
		User user = userService.findByMobile(verifyDto.getMobileNumber());

		if(user == null) {
			log.error("No User found");
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}else {
			int otp = otpService.generateOtp();
			
			log.info("OTP:: "+otp);
			Otp otpPersist = otpService.save(otp, user);
			
			//TODO send sms to customer mobile number
			//otpService.sendSMS();
			
			if(otpPersist == null) {
				log.error("could not save OTP :: ");
			}
			
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/verify-otp")
	public @ResponseBody ResponseEntity<Boolean> verifyOtp(@RequestBody VerifyDto verifyDto){
		
		User user = null;
		
		if(verifyDto.getMobileNumber() != null) {
			user = userService.findByMobile(verifyDto.getMobileNumber());
		}else {
			user = userService.findByEmail(verifyDto.getEmailId());
		}
		boolean result = false;
		
		if(user == null) {
			log.error("No user found");
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}else {
			result = otpService.verifyOtp(verifyDto.getOtp());
			log.info("verify Otp:: "+result);
			if(result) {
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
	}
}
