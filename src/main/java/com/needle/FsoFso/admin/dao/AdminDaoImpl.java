package com.needle.FsoFso.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminProductDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;
import com.needle.FsoFso.admin.dto.DailyDetailDto;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	SqlSession session;
	
	String ns = "Admin.";

	@Override
	public AdminMainRequestDto adminMain() {
		List<DailyDetailDto> dtos = session.selectList(ns+"adminMain");
		return new AdminMainRequestDto(dtos);
	}

	@Override
	public AdminMemberListRequestDto adminMemberListRequest() {
		List<AdminMemberDto> dtos = session.selectList(ns+"adminMemberList");
		return new AdminMemberListRequestDto(dtos);
	}

	@Override
	public AdminProductListRequestDto adminProductListRequest() {
		List<AdminProductDto> dtos = session.selectList(ns+"adminProductList");
		return new AdminProductListRequestDto(dtos);
	}

}
