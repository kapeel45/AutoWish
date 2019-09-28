package com.pongo.autowish.auto.car;

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
@RequestMapping("/car")
public class CarController {

	@Autowired
	CarService carService;
	
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<Car> addCar(@RequestBody CarDto carDto) {
		Car car = carService.addCar(carDto);
		if(car != null) {
			return new ResponseEntity<Car>(car, HttpStatus.CREATED);
		}
		return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Car> getCar(@PathVariable String id) {
		
		Car car = carService.getCar(id);
		
		if(car == null) {
			return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);	
		}
		
		return new ResponseEntity<Car>(car,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<Car>> getAllCar() {
		
		List<Car> lstCar = carService.getAllCar();
		
		if(lstCar == null) {
			return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Car>>(lstCar,HttpStatus.OK);
	}
}
