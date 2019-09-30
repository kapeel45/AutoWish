package com.pongo.autowish.auto.bike;

public class BikeDto {

	private String bikeModelName;
	private String bikeCompanyName;
	private String numberPlate;
	
	private String bikeColor;
	
	private long userId;

	public String getBikeModelName() {
		return bikeModelName;
	}

	public void setBikeModelName(String bikeModelName) {
		this.bikeModelName = bikeModelName;
	}

	public String getBikeCompanyName() {
		return bikeCompanyName;
	}

	public void setBikeCompanyName(String bikeCompanyName) {
		this.bikeCompanyName = bikeCompanyName;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getBikeColor() {
		return bikeColor;
	}

	public void setBikeColor(String bikeColor) {
		this.bikeColor = bikeColor;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
