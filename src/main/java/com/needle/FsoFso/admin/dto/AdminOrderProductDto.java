package com.needle.FsoFso.admin.dto;

import java.time.Instant;

public class AdminOrderProductDto {
	
	private long id;
	private long orderId;
	private long memberId;
	private long productId;
	private String productName;
	private String productThumbnailUrl;
	private int quantity;
	private int unitPrice;
	private Instant orderedAt;
	private Instant updatedAt;

	public AdminOrderProductDto(){}

	public AdminOrderProductDto(long id, long orderId, long memberId, long productId, String productName,
			String productThumbnailUrl, int quantity, int unitPrice, Instant orderedAt, Instant updatedAt) {
		this.id = id;
		this.orderId = orderId;
		this.memberId = memberId;
		this.productId = productId;
		this.productName = productName;
		this.productThumbnailUrl = productThumbnailUrl;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.orderedAt = orderedAt;
		this.updatedAt = updatedAt;
	}

	public long getId() {
		return id;
	}

	public long getOrderId() {
		return orderId;
	}

	public long getMemberId() {
		return memberId;
	}

	public long getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public Instant getOrderedAt() {
		return orderedAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductThumbnailUrl() {
		return productThumbnailUrl;
	}

}
