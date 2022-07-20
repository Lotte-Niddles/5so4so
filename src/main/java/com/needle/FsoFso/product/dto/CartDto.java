package com.needle.FsoFso.product.dto;

public class CartDto {

	private long id;
	private long memberId;
	private long productId;
	private int quantity;

	public CartDto() {
	}
	
	public CartDto(long id, long memberId, long productId, int quantity) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "CartDto [id=" + id + ", memberId=" + memberId + ", productId=" + productId + ", quantity=" + quantity
				+ "]";
	}

}
