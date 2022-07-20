package com.needle.FsoFso.admin.dto;

import java.util.List;

public class AdminMemberListRequestDto {
	
	List<AdminMemberDto> adminMembers;
	
	public AdminMemberListRequestDto(){}
	
	public AdminMemberListRequestDto(List<AdminMemberDto> adminMembers) {
		this.adminMembers = adminMembers;
	}

	public List<AdminMemberDto> getAdminMembers() {
		return adminMembers;
	}
	
}
