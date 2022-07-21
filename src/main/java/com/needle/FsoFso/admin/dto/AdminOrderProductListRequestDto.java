package com.needle.FsoFso.admin.dto;

import java.util.List;

public class AdminOrderProductListRequestDto {
	
	List<AdminOrderProductDto> AdminOrderProducts;
	
	public AdminOrderProductListRequestDto(){}

	public AdminOrderProductListRequestDto(List<AdminOrderProductDto> AdminOrderProducts) {
		this.AdminOrderProducts = AdminOrderProducts;
	}

	public List<AdminOrderProductDto> getAdminOrders() {
		return AdminOrderProducts;
	}
}
