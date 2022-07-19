package com.needle.FsoFso.admin.dto;

import java.io.Serializable;
import java.util.List;

public class AdminProductListRequestDto implements Serializable{
	List<AdminProductDto> adminProducts;
	
	public AdminProductListRequestDto(){}

	public AdminProductListRequestDto(List<AdminProductDto> adminProducts) {
		super();
		this.adminProducts = adminProducts;
	}

	public List<AdminProductDto> getAdminProducts() {
		return adminProducts;
	}
	
	
}
