package com.needle.FsoFso.search.dto;

public class SearchParamDto {

	private String keyWord;
	private int pageNumber;
	private int startNum;
	private int endNum;

	public SearchParamDto() {
	}

	public SearchParamDto(String keyWord, int pageNumber, int startNum, int endNum) {
		this.keyWord = keyWord;
		this.pageNumber = pageNumber;
		this.startNum = startNum;
		this.endNum = endNum;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
}