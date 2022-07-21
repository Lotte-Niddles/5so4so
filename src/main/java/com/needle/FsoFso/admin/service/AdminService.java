package com.needle.FsoFso.admin.service;

import java.util.List;

import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderProductDto;
import com.needle.FsoFso.admin.dto.AdminProductDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;

public interface AdminService {
	
	AdminMainRequestDto adminWeekStatusRequest();
	
	AdminMemberListRequestDto adminMemberListRequest();
	
	AdminProductListRequestDto adminProductListRequest();

	List<AdminOrderProductDto> findOrderProductsByOrderId(long orderId);
}
