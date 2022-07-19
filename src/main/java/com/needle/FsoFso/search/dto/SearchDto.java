package com.needle.FsoFso.search.dto;

import java.time.Instant;

public class SearchDto {
	
	/**
	 * 
		CREATE TABLE PRODUCT (
			ID BIGINT AUTO_INCREMENT PRIMARY KEY ,
			NAME VARCHAR(50),
			THUMBNAIL_URL VARCHAR(500) NOT NULL,
			PRICE INT  NOT NULL,
		    STOCK INT  NOT NULL,
			CREATED_AT TIMESTAMP NOT NULL,
			UPDATED_AT TIMESTAMP NOT NULL
		);
	 */
	
	private Long id;
	private String name;
	private String thumbnailUrl;
	private int price;
	private int stock;
	private Instant createdAt;
	private Instant updatedAt;

	public SearchDto() {
	}

	public SearchDto(Long id, String name, String thumbnailUrl, int price, int stock, Instant createdAt,
			Instant updatedAt) {
		this.id = id;
		this.name = name;
		this.thumbnailUrl = thumbnailUrl;
		this.price = price;
		this.stock = stock;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getthumbnailUrl() {
		return thumbnailUrl;
	}

	public void setthumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Instant getcreatedAt() {
		return createdAt;
	}

	public void setcreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getupdatedAt() {
		return updatedAt;
	}

	public void setupdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
}