package com.pongo.autowish.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<User> addUser(@RequestBody User userDto) {
		User user = userService.addUser(userDto);
		if(user != null) {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<User> getUser(@PathVariable String id) {
		
		User user = userService.getUser(id);
		
		if(user == null) {
			log.error("User not found:: userId: "+id);
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);	
		}
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<User>> getAllUser() {
		
		List<User> lstUser = userService.getAllUser();
		
		if(lstUser == null) {
			log.error("No User found");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<User>>(lstUser,HttpStatus.OK);
	}
	
	
	@GetMapping("/find-by-mobile/{mobileNumber}")
	public @ResponseBody ResponseEntity<User> findByMobile(@PathVariable String mobileNumber){
		
		User user = userService.findByMobile(mobileNumber);
		
		if(user == null) {
			log.error("No User found");
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
}
