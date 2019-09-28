package com.pongo.autowish.auto.bike;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

	@Autowired
	BikeRepository bikeRepo;
	
	public Bike addBike(Bike bike) {
		return bikeRepo.save(bike);
	}

	public Bike getBike(String id) {
		return bikeRepo.getOne(Long.parseLong(id));
	}

	public List<Bike> getAllBike() {
		return bikeRepo.findAll();
	}
}
