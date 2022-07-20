package com.needle.FsoFso.search.dao;

import java.util.List;

import com.needle.FsoFso.search.dto.SearchDto;

public interface SearchDao {
	
	List<SearchDto> searchList(String keyWord);
}
