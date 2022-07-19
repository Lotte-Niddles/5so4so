package com.needle.FsoFso.admin.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AdminMemberDto implements Serializable {
	String name;
	String id;
	LocalDateTime birth;
	int purchasesCount;
	int totalPurchase;
	LocalDateTime createdAt;
	
	AdminMemberDto(){}

	public AdminMemberDto(String name, String id, LocalDateTime birth, int purchasesCount, int totalPurchase,
			LocalDateTime createdAt) {
		super();
		this.name = name;
		this.id = id;
		this.birth = birth;
		this.purchasesCount = purchasesCount;
		this.totalPurchase = totalPurchase;
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getBirth() {
		return birth;
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
