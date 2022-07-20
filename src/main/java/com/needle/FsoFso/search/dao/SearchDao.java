package com.needle.FsoFso.search.dao;

import java.util.List;

import com.needle.FsoFso.search.dto.SearchDto;
import com.needle.FsoFso.search.dto.SearchParamDto;

public interface SearchDao {
	
	List<SearchDto> searchList(SearchParamDto searchParamDto);
	int getSearchListCount(SearchParamDto searchParamDto);
}
