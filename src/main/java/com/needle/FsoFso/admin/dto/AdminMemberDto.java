package com.needle.FsoFso.admin.dto;

import java.time.Instant;

public class AdminMemberDto {
	
	private String nickname; // 닉네임
	private Long id; // 아이디
	private Long providerId; // 카카오ID
	private String ageRange; // 연령대
	private String gender; // 성별
	private int purchasesCount;
	private int totalPurchase;
	private Instant createdAt;
	private Instant updatedAt;
	
	public AdminMemberDto(){}
	
	public AdminMemberDto(String nickname, Long id, Long providerId, String ageRange, String gender, int purchasesCount,
			int totalPurchase, Instant createdAt, Instant updatedAt) {
		this.nickname = nickname;
		this.id = id;
		this.providerId = providerId;
		this.ageRange = ageRange;
		this.gender = gender;
		this.purchasesCount = purchasesCount;
		this.totalPurchase = totalPurchase;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public String getNickname() {
		return nickname;
	}

	public Long getId() {
		return id;
	}

	public Long getProviderId() {
		return providerId;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public String getGender() {
		return gender;
	}

	public int getPurchasesCount() {
		return purchasesCount;
	}

	public int getTotalPurchase() {
		return totalPurchase;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}
	
	public Instant getUpdatedAt() {
		return updatedAt;
	}
	
}
