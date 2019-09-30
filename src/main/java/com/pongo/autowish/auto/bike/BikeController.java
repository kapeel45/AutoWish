package com.pongo.autowish.auto.bike;

import java.util.List;

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
@RequestMapping("/bike")
public class BikeController {

	@Autowired
	BikeService bikeService;
	
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<Bike> addBike(@RequestBody BikeDto bikeDto) {
		
		Bike bike= bikeService.addBike(bikeDto);
		
		if(bike != null) {
			return new ResponseEntity<Bike>(bike,HttpStatus.CREATED);
		}
		return new ResponseEntity<Bike>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Bike> getBike(@PathVariable String id) {
		
		Bike bike = bikeService.getBike(id);
		
		if(bike == null) {
			return new ResponseEntity<Bike>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Bike>(bike, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<Bike>> getAllBike() {
		
		List<Bike> lstBike = bikeService.getAllBike();
		
		if(lstBike == null) {
			return new ResponseEntity<List<Bike>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Bike>>(lstBike, HttpStatus.OK);
	}
}
