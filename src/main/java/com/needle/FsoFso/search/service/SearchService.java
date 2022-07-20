package com.needle.FsoFso.search.service;

import java.util.List;

import com.needle.FsoFso.search.dto.SearchDto;
import com.needle.FsoFso.search.dto.SearchParamDto;

public interface SearchService {
	
	List<SearchDto> searchList(SearchParamDto searchParamDto);
	int getSearchListCount(SearchParamDto searchParamDto);
	
}
