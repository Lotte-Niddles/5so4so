package com.needle.FsoFso.review.dto;

public class MemberProductDto {

	private long memberId;
	private long productId;

	public MemberProductDto() {
	}

	public MemberProductDto(long memberId, long productId) {
		super();
		this.memberId = memberId;
		this.productId = productId;
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

}
