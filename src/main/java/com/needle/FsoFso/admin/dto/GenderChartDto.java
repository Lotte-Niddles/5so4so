package com.needle.FsoFso.admin.dto;

public class GenderChartDto {

	private int count;
	private String Gender;

	public GenderChartDto(int count, String gender) {
		super();
		this.count = count;
		Gender = gender;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

}
