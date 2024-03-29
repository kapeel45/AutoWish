package com.pongo.autowish.document;

public class DocumentDto {

	private String documentType;
	
	private String documentName;

	private String documentFrontImage;
	
	private String documentBackImage;
	
	private String userId;

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
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

	public void setDocumentBackImage(String documentBackImage) {
		this.documentBackImage = documentBackImage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
