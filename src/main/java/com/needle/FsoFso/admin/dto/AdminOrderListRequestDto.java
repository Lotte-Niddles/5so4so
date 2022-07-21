package com.needle.FsoFso.admin.dto;

import java.util.List;

public class AdminOrderListRequestDto {
	
	List<AdminOrderDto> adminOrders;
	
	public AdminOrderListRequestDto(){}

	public AdminOrderListRequestDto(List<AdminOrderDto> adminOrders) {
		this.adminOrders = adminOrders;
	}

	public List<AdminOrderDto> getAdminOrders() {
		return adminOrders;
	}
	
}
