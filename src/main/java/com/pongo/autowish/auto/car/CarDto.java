package com.pongo.autowish.auto.car;

public class CarDto {

	private String fuelType;
	private String transmission;
	private String carColor;
	private String carNumber;
	private String carCompanyName;
	private String carModelName;
	private long userId;
	
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarCompanyName() {
		return carCompanyName;
	}
	public void setCarCompanyName(String carCompanyName) {
		this.carCompanyName = carCompanyName;
	}
	public String getCarModelName() {
		return carModelName;
	}
	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	
}
