package com.needle.FsoFso.admin.dto;

import java.time.Instant;

public class AdminOrderProductDto {
	private long id;
	private long orderId;
	private long memberId;
	private long productId;
	private int quantity;
	private int unitPrice;
	private Instant orderedAt;
	private Instant updatedAt;

	public AdminOrderProductDto(long id, long orderId, long memberId, long productId, int quantity, int unitPrice,
			Instant orderedAt, Instant updatedAt) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.memberId = memberId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.orderedAt = orderedAt;
		this.updatedAt = updatedAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Instant getOrderedAt() {
		return orderedAt;
	}

	public void setOrderedAt(Instant orderedAt) {
		this.orderedAt = orderedAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "AdminOrderProductDto [id=" + id + ", orderId=" + orderId + ", memberId=" + memberId + ", productId="
				+ productId + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", orderedAt=" + orderedAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
