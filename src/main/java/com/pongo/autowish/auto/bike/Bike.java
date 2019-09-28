package com.pongo.autowish.auto.bike;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.pongo.autowish.user.User;

@Entity
@JsonInclude(Include.NON_EMPTY)
public class Bike implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bikeId;
	
	private String bikeModelName;
	private String bikeCompanyName;
	private String numberPlate;
	
	private String bikeColor;
	
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

	public long getBikeId() {
		return bikeId;
	}

	public void setBikeId(long bikeId) {
		this.bikeId = bikeId;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	/*
	 * private boolean isHornOk; private boolean isHeadlightOk;
	 * 
	 * private boolean isBrakeOk;
	 * 
	 * private boolean isTailLightOk;
	 * 
	 * private boolean isIndicatorOk;
	 */
	
}
