package com.needle.FsoFso.admin.dto;

import java.time.Instant;

public class AdminOrderDto {
	
	Long id;
	Long memberId;
	int totalPrice;
	int productCount;
	Instant orderedAt;
	Instant updatedAt;
	
	public AdminOrderDto() {}
	
	public AdminOrderDto(Long id, Long memberId, int productCount, int totalPrice, Instant orderedAt, Instant updatedAt) {
		this.id = id;
		this.memberId = memberId;
		this.totalPrice = totalPrice;
		this.productCount = productCount;
		this.orderedAt = orderedAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	
	public int getProductCount() {
		return productCount;
	}

	public Instant getOrderedAt() {
		return orderedAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}
	
	
}
