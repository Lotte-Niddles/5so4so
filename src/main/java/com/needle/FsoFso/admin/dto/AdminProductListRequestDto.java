package com.needle.FsoFso.admin.dto;

import java.util.List;

public class AdminProductListRequestDto {

	private List<AdminProductDto> adminProducts;
	
	public AdminProductListRequestDto(){}
	
	public AdminProductListRequestDto(List<AdminProductDto> adminProducts) {
		this.adminProducts = adminProducts;
	}

	public List<AdminProductDto> getAdminProducts() {
		return adminProducts;
	}
	
	
}
