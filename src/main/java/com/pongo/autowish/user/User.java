package com.pongo.autowish.user;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.pongo.autowish.address.Address;
import com.pongo.autowish.auto.bike.Bike;
import com.pongo.autowish.auto.car.Car;
import com.pongo.autowish.document.Document;
import com.pongo.autowish.otp.Otp;

@Entity
@JsonInclude(Include.NON_EMPTY)
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	private String firstName;
	
	private String lastName;
	
	@Email
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String mobile;

	private String currentArea;
	
	private Double lattitude;
	
	private Double longitude;
	
	@Column(nullable = false)
	private char isEmailVerified = 'N';

	@Column(nullable = false)
	private char isMobileVerified = 'N';
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
    private Set<Address> address;
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
    private Set<Bike> bike;
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
    private Set<Car> car;
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
    private Set<Document> doc;
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
    private Set<Otp> otp;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fistName) {
		this.firstName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCurrentArea() {
		return currentArea;
	}

	public void setCurrentArea(String currentArea) {
		this.currentArea = currentArea;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public char getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(char isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public char getIsMobileVerified() {
		return isMobileVerified;
	}

	public void setIsMobileVerified(char isMobileVerified) {
		this.isMobileVerified = isMobileVerified;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", currentArea=" + currentArea + ", lattitude=" + lattitude + ", longitude="
				+ longitude + ", address=" + address + ", bike=" + bike + ", car=" + car + "]";
	}
	
}
