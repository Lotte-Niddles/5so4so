package com.needle.FsoFso.admin.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AdminProductDto implements Serializable{
	Long productId;
	String imgUrl;
	String productName;
	int stock;
	int salesCount;
	LocalDateTime createdAt;
	LocalDateTime updatedAt;
	
	public AdminProductDto(){}
	public AdminProductDto(Long productId, String imgUrl, String productName, int stock, int salesCount,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.productId = productId;
		this.imgUrl = imgUrl;
		this.productName = productName;
		this.stock = stock;
		this.salesCount = salesCount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Long getProductId() {
		return productId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public String getProductName() {
		return productName;
	}
	public int getStock() {
		return stock;
	}
	public int getSalesCount() {
		return salesCount;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
}
