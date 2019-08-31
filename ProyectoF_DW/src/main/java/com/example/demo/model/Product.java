package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	private String description;
	
	private Date dateCollection;
	private Long maximunStock;
	private Long minimunStock;
	private Double maximunPrice;
	private Double minimunPrice;
	private Date expiry;
	
	public Product() {
		
	}

	
	
	public Product(Long productId, String description, Date dateCollection, Long maximunStock, Long minimunStock,
			Double maximunPrice, Double minimunPrice, Date expiry) {
		super();
		this.productId = productId;
		this.description = description;
		this.dateCollection = dateCollection;
		this.maximunStock = maximunStock;
		this.minimunStock = minimunStock;
		this.maximunPrice = maximunPrice;
		this.minimunPrice = minimunPrice;
		this.expiry = expiry;
	}



	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateCollection() {
		return dateCollection;
	}
	public void setDateCollection(Date dateCollection) {
		this.dateCollection = dateCollection;
	}
	public Long getMaximunStock() {
		return maximunStock;
	}
	public void setMaximunStock(Long maximunStock) {
		this.maximunStock = maximunStock;
	}
	public Long getMinimunStock() {
		return minimunStock;
	}
	public void setMinimunStock(Long minimunStock) {
		this.minimunStock = minimunStock;
	}
	public Double getMaximunPrice() {
		return maximunPrice;
	}
	public void setMaximunPrice(Double maximunPrice) {
		this.maximunPrice = maximunPrice;
	}
	public Double getMinimunPrice() {
		return minimunPrice;
	}
	public void setMinimunPrice(Double minimunPrice) {
		this.minimunPrice = minimunPrice;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	
	
}
