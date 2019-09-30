package com.pongo.autowish.document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pongo.autowish.user.User;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private DocumentType documentType;
	
	private String documentName;

	@Column(length = 20)
	private String documentFrontImage;
	
	@Column(length = 20)
	private String documentBackImage;
	
	private char isVerified;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	
	public String getDocumentFrontImage() {
		return documentFrontImage;
	}

	public void setDocumentFrontImage(String documentFrontImage) {
		this.documentFrontImage = documentFrontImage;
	}

	public String getDocumentBackImage() {
		return documentBackImage;
	}

	public void setDocumentBackImage(String documentbackImage) {
		this.documentBackImage = documentbackImage;
	}

	public char getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(char isVerified) {
		this.isVerified = isVerified;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
