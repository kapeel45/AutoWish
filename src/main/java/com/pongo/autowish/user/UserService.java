package com.pongo.autowish.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public User addUser(User user) {
		return userRepo.save(user);
	}

	public User getUser(String id) {
		return userRepo.getOne(Long.parseLong(id));
	}

	public List<User> getAllUser() {
		return userRepo.findAll();
	}
}
