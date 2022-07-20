package com.needle.FsoFso.admin.dto;

import java.time.Instant;

public class DailyDetailDto {
	
	private Instant date;
	private int sales;
	private int salesCnt;
	private int signinCnt;

	public DailyDetailDto() {}
	
	public DailyDetailDto(Instant date, int sales, int salesCnt, int signinCnt) {
		this.date = date;
		this.sales = sales;
		this.salesCnt = salesCnt;
		this.signinCnt = signinCnt;
	}

	public Instant getDate() {
		return date;
	}
	
	public int getSales() {
		return sales;
	}
	
	public int getSalesCnt() {
		return salesCnt;
	}
	
	public int getSigninCnt() {
		return signinCnt;
	}

	public boolean nullCheck() {
		return (date == null);
	}
	
	
}
