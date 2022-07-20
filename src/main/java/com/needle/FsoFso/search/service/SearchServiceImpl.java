package com.needle.FsoFso.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.needle.FsoFso.search.dao.SearchDao;
import com.needle.FsoFso.search.dto.SearchDto;
import com.needle.FsoFso.search.dto.SearchParamDto;

@Service
public class SearchServiceImpl implements SearchService {
	
	private final SearchDao searchDao;
	
	public SearchServiceImpl(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	
	@Override
	public List<SearchDto> searchList(SearchParamDto searchParamDto) {
		return searchDao.searchList(searchParamDto);
	}

	@Override
	public int getSearchListCount(SearchParamDto searchParamDto) {
		return searchDao.getSearchListCount(searchParamDto);
	}
}
