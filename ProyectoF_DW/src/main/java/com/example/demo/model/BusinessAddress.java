package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "business_address")
public class BusinessAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBusinessAddress;
	private Integer typeRoad;
	private String nameAddress;
	private Integer numberAddress;
	private String blockNumber;
	
	public BusinessAddress() {
		
	}
	
	public BusinessAddress(Long idBusinessAddress, Integer typeRoad, String nameAddress, Integer numberAddress,
			String blockNumber) {
		super();
		this.idBusinessAddress = idBusinessAddress;
		this.typeRoad = typeRoad;
		this.nameAddress = nameAddress;
		this.numberAddress = numberAddress;
		this.blockNumber = blockNumber;
	}
	
	public Long getIdBusinessAddress() {
		return idBusinessAddress;
	}
	public void setIdBusinessAddress(Long idBusinessAddress) {
		this.idBusinessAddress = idBusinessAddress;
	}
	public Integer getTypeRoad() {
		return typeRoad;
	}
	public void setTypeRoad(Integer typeRoad) {
		this.typeRoad = typeRoad;
	}
	public String getNameAddress() {
		return nameAddress;
	}
	public void setNameAddress(String nameAddress) {
		this.nameAddress = nameAddress;
	}
	public Integer getNumberAddress() {
		return numberAddress;
	}
	public void setNumberAddress(Integer numberAddress) {
		this.numberAddress = numberAddress;
	}
	public String getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}
	
	

}
