package com.needle.FsoFso.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needle.FsoFso.admin.dao.AdminDao;
import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderProductListRequestDto;
import com.needle.FsoFso.admin.dto.AdminProductDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;

	@Override
	public AdminMainRequestDto adminWeekStatusRequest() {
		return dao.adminWeekStatusRequest();
	}

	@Override
	public AdminMemberListRequestDto adminMemberListRequest(String keyword) {
		return dao.adminMemberListRequest(keyword);
	}

	@Override
	public AdminProductListRequestDto adminProductListRequest(AdminProductDto adminProductDto) {
		return dao.adminProductListRequest(adminProductDto);
	}

	@Override
	public AdminOrderProductListRequestDto findOrderProductsByOrderId(long orderId) {
		return dao.findOrderProductsByOrderId(orderId);
	}

	@Override
	public AdminOrderListRequestDto adminOrderListRequest() {
		return dao.adminOrderListRequest();
	}

}
