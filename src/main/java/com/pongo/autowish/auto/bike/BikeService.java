package com.pongo.autowish.auto.bike;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pongo.autowish.user.User;
import com.pongo.autowish.user.UserRepository;

@Service
public class BikeService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BikeRepository bikeRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public Bike addBike(BikeDto bikeDto) {
		
		try {
			Optional<User> user = userRepo.findById(bikeDto.getUserId());
			
			if(user.isPresent()) {
			
				Bike bike = new Bike();
				
				bike.setBikeModelName(bikeDto.getBikeModelName());
				bike.setBikeCompanyName(bikeDto.getBikeCompanyName());
				bike.setBikeColor(bikeDto.getBikeColor());
				bike.setNumberPlate(bikeDto.getNumberPlate());
				bike.setUser(user.get());
				
				return bikeRepo.save(bike);
			}else {
				log.error("user not found or not available:: userId:"+bikeDto.getUserId());
			}
		}catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

	public Bike getBike(String id) {
		try {
			Optional<Bike> bike = bikeRepo.findById(Long.parseLong(id));
			
			if(bike.isPresent()) {
				return bike.get();
			}else {
				log.error("No bike found:: bikeId: "+id);
			}
		}catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	public List<Bike> getAllBike() {
		
		try {
			List<Bike> lstBike = bikeRepo.findAll();
			if(!lstBike.isEmpty()) {
				return lstBike;
			}else {
				log.error("No Bike found");
			}
		}catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
