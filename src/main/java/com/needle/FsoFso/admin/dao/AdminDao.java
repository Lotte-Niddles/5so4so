package com.needle.FsoFso.admin.dao;

import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;

public interface AdminDao {
	AdminMainRequestDto adminMain();
	AdminMemberListRequestDto adminMemberListRequest();
	AdminProductListRequestDto adminProductListRequest();
}
