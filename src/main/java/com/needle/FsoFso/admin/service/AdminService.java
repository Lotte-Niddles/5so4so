package com.needle.FsoFso.admin.service;

import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminProductDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;

public interface AdminService {
	AdminMainRequestDto adminMain();
	AdminMemberListRequestDto adminMemberListRequest();
	AdminProductListRequestDto adminProductListRequest();
}
