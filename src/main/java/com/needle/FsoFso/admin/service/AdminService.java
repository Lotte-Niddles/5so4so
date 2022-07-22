package com.needle.FsoFso.admin.service;

import java.util.List;

import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderProductListRequestDto;
import com.needle.FsoFso.admin.dto.AdminProductDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;
import com.needle.FsoFso.admin.dto.AgeChartDto;
import com.needle.FsoFso.admin.dto.GenderChartDto;

public interface AdminService {

	AdminMainRequestDto adminWeekStatusRequest();

	AdminMemberListRequestDto adminMemberListRequest(String keyword);

	AdminOrderProductListRequestDto findOrderProductsByOrderId(long orderId);

	AdminOrderListRequestDto adminOrderListRequest(Long keyWord);

	AdminProductListRequestDto adminProductListRequest(AdminProductDto adminProductDto);

	List<GenderChartDto> findGenderCount();

	List<AgeChartDto> findAgeCount();
}
