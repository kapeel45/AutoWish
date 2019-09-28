package com.pongo.autowish.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public @ResponseBody User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody User getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/")
	public @ResponseBody List<User> getAllUser() {
		return userService.getAllUser();
	}
}
