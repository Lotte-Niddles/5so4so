package com.needle.FsoFso.admin.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AdminMemberDto implements Serializable {
	String nickname; // 닉네임
	Long id; // 아이디
	Long providerId; // 카카오ID
	String ageRange; // 연령대
	String gender; // 성별
	int purchasesCount;
	int totalPurchase;
	LocalDateTime createdAt;
	
	public AdminMemberDto(){}
	public AdminMemberDto(String nickname, Long id, Long providerId, String ageRange, String gender, int purchasesCount,
			int totalPurchase, LocalDateTime createdAt) {
		super();
		this.nickname = nickname;
		this.id = id;
		this.providerId = providerId;
		this.ageRange = ageRange;
		this.gender = gender;
		this.purchasesCount = purchasesCount;
		this.totalPurchase = totalPurchase;
		this.createdAt = createdAt;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
}
