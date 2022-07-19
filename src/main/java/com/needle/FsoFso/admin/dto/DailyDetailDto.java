package com.needle.FsoFso.admin.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class DailyDetailDto implements Serializable {
	
	LocalDate date;
	int sales;
	int salesCnt;
	int signinCnt;

	public DailyDetailDto() {}

	public DailyDetailDto(LocalDate date, int sales, int salesCnt, int signinCnt) {
		super();
		this.date = date;
		this.sales = sales;
		this.salesCnt = salesCnt;
		this.signinCnt = signinCnt;
	}

	public LocalDate getDate() {
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
}
