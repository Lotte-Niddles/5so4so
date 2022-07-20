package com.needle.FsoFso.admin.dao;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
	private SqlSession session;
	
	private final String ns = "Admin.";

	@Override
	public AdminMainRequestDto adminMain() {
		List<DailyDetailDto> dtos = new ArrayList<>(); 
		
		for(int i = 0; i < 7; i++) {
			String day = Instant.now().minus(i, ChronoUnit.DAYS).toString().substring(0, 10);
			DailyDetailDto dto = session.selectOne(ns+"adminMain", day);
			
			if(dto.nullCheck()) continue;
			dtos.add(dto);
		}
		
		return new AdminMainRequestDto(dtos);
	}

	@Override
	public AdminMemberListRequestDto adminMemberListRequest() {
		List<AdminMemberDto> dtos = new ArrayList<>();
		dtos = session.selectList(ns+"adminMemberList");
		return new AdminMemberListRequestDto(dtos);
	}

	@Override
	public AdminProductListRequestDto adminProductListRequest() {
		List<AdminProductDto> dtos = new ArrayList<>();
		dtos = session.selectList(ns+"adminProductList");
		return new AdminProductListRequestDto(dtos);
	}

}
