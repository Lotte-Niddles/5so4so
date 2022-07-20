package com.needle.FsoFso.admin.dto;

import java.time.Instant;

public class SellerProductDto {

	private int id;
	private String name;
	private String thumbnailUrl;
	private int price;
	private int stock;
	private Instant createdAt;
	private Instant updatedAt;
	
	public SellerProductDto() {
	}

	public SellerProductDto(int id, String name, String thumbnailUrl, int price, int stock, Instant createdAt,
			Instant updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.thumbnailUrl = thumbnailUrl;
		this.price = price;
		this.stock = stock;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
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

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "SellerProductDto [id=" + id + ", name=" + name + ", thumbnailUrl=" + thumbnailUrl + ", price=" + price
				+ ", stock=" + stock + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
