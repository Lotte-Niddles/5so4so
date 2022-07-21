package com.needle.FsoFso.admin.service;

import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderProductListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderListRequestDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;

public interface AdminService {
	
	AdminMainRequestDto adminWeekStatusRequest();
	
	AdminMemberListRequestDto adminMemberListRequest();
	
	AdminProductListRequestDto adminProductListRequest();

	AdminOrderProductListRequestDto findOrderProductsByOrderId(long orderId);
	
	AdminOrderListRequestDto adminOrderListRequest();
}
