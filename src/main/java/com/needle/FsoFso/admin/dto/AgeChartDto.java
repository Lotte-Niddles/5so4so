package com.needle.FsoFso.admin.dto;

public class AgeChartDto {

	private int count;
	private String age;

	public AgeChartDto(int count, String age) {
		super();
		this.count = count;
		this.age = age;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
