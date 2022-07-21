package com.needle.FsoFso.admin.dao;

import java.util.List;

import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderProductDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;

public interface AdminDao {
	
	AdminMainRequestDto adminWeekStatusRequest();
	
	AdminMemberListRequestDto adminMemberListRequest();
	
	AdminProductListRequestDto adminProductListRequest();

	List<AdminOrderProductDto> findOrderProductsByOrderId(long orderId);
}
