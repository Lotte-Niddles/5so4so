package com.needle.FsoFso.admin.dto;

import java.util.ArrayList;
import java.util.List;

public class AdminMainRequestDto {
	
	private List<DailyDetailDto> dailyDetails = new ArrayList<>();
	
	public AdminMainRequestDto(){}
	
	public AdminMainRequestDto(List<DailyDetailDto> dailyDetails) {
		this.dailyDetails = dailyDetails;
	}

	public List<DailyDetailDto> getDailyDetails() {
		return dailyDetails;
	}
}
