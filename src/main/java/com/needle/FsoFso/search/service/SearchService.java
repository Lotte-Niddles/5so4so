package com.needle.FsoFso.search.service;

import java.util.List;

import com.needle.FsoFso.search.dto.SearchDto;

public interface SearchService {
	
	List<SearchDto> searchList(String keyWord);
	
}
