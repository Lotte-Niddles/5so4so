package com.needle.FsoFso.admin.dto;

import java.io.Serializable;
import java.util.List;

public class AdminMemberListRequestDto implements Serializable {
	
	List<AdminMemberDto> adminMembers;
	
	public AdminMemberListRequestDto(){}

	public AdminMemberListRequestDto(List<AdminMemberDto> adminMembers) {
		super();
		this.adminMembers = adminMembers;
	}

	public List<AdminMemberDto> getAdminMembers() {
		return adminMembers;
	}
	
}
