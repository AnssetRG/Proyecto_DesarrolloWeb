package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "providers")
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProvider;
	private Integer documentType;
	private String documentNumber;
	private String businessName;
	private String phoneNumber;
	
	@OneToOne
	private User user;
	
	public Provider() {
		
	}
	

	
	public Provider(Long idProvider, Integer documentType, String documentNumber, String businessName,
			String phoneNumber, User user) {
		this.idProvider = idProvider;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.businessName = businessName;
		this.phoneNumber = phoneNumber;
		this.user = user;
	}



	public Long getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(Long idProvider) {
		this.idProvider = idProvider;
	}
	public Integer getDocumentType() {
		return documentType;
	}
	public void setDocumentType(Integer documentType) {
		this.documentType = documentType;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
