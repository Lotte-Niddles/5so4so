package com.needle.FsoFso.admin.dto;

import java.time.Instant;

public class AdminProductDto {

	private Long productId;
	private String imgUrl;
	private String productName;
	private int stock;
	private int salesCount;
	private Instant createdAt;
	private Instant updatedAt;
	private String keyWord;

	public AdminProductDto() {
	}

	public AdminProductDto(Long productId, String imgUrl, String productName, int stock, int salesCount,
			Instant createdAt, Instant updatedAt, String keyWord) {
		super();
		this.productId = productId;
		this.imgUrl = imgUrl;
		this.productName = productName;
		this.stock = stock;
		this.salesCount = salesCount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.keyWord = keyWord;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
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

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

}
