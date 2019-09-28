package com.pongo.autowish.auto.bike;

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
@RequestMapping("/bike")
public class BikeController {

	@Autowired
	BikeService bikeService;
	
	@PostMapping("/add")
	public @ResponseBody Bike addBike(@RequestBody Bike bike) {
		return bikeService.addBike(bike);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Bike getBike(@PathVariable String id) {
		return bikeService.getBike(id);
	}
	
	@GetMapping("/")
	public @ResponseBody List<Bike> getAllBike() {
		return bikeService.getAllBike();
	}
}
