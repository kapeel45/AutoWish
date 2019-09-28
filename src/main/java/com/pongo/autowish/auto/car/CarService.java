package com.pongo.autowish.auto.car;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pongo.autowish.user.User;
import com.pongo.autowish.user.UserRepository;

@Service
public class CarService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CarRepository carRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public Car addCar(CarDto carDto) {
		
		try {
			Optional<User> user = userRepo.findById(carDto.getUserId());
			
			//log.info("User found :: "+user);
			if(user.isPresent()) {
				Car car = new Car();
				car.setCarColor(carDto.getCarColor());
				car.setCarCompanyName(carDto.getCarCompanyName());
				car.setCarModelName(carDto.getCarModelName());
				car.setCarNumber(carDto.getCarNumber());
				car.setFuelType(FuelType.valueOf(carDto.getFuelType()));
				car.setTransmission(Transmission.valueOf(carDto.getTransmission()));
				
				car.setUser(user.get());
				
				return carRepo.save(car);
			}
			else {
				log.error("user not found or not available:: userId:"+carDto.getUserId());
			}
		}
		catch(Exception e) {
			log.error("Exception:: "+e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

	public Car getCar(String id) {
		try {
			Optional<Car> car = carRepo.findById(Long.parseLong(id));
			
			if(car.isPresent()) {
				log.info("car found :: carId: "+car.get().getCarId());
				return car.get();
			}else {
				log.error("No such car found error:: carId:"+id);
			}
		}catch(Exception e) {
			log.error("Exception :: "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public List<Car> getAllCar() {
		try {
			List<Car> lstCar = carRepo.findAll();
			
			if(!lstCar.isEmpty()) {
				log.info("All cars found");
				return lstCar;
			}
		}catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

}
