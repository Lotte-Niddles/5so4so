package com.needle.FsoFso.admin.dto;

import java.io.Serializable;
import java.util.List;

public class AdminMainRequestDto implements Serializable{
	
	List<DailyDetailDto> dailyDetails;
	
	public AdminMainRequestDto(){}
	
	public AdminMainRequestDto(List<DailyDetailDto> dailyDetails) {
		super();
		this.dailyDetails = dailyDetails;
	}

	public List<DailyDetailDto> getDailyDetails() {
		return dailyDetails;
	}
	
	
}
