package com.needle.FsoFso.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needle.FsoFso.admin.dao.AdminDao;
import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao dao;

	@Override
	public AdminMainRequestDto adminWeekStatusRequest() {
		return dao.adminWeekStatusRequest();
	}

	@Override
	public AdminMemberListRequestDto adminMemberListRequest() {
		return dao.adminMemberListRequest();
	}

	@Override
	public AdminProductListRequestDto adminProductListRequest() {
		return dao.adminProductListRequest();
	}
	
}
