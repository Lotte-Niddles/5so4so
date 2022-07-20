package com.needle.FsoFso.search.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.needle.FsoFso.search.dto.SearchDto;
import com.needle.FsoFso.search.dto.SearchParamDto;
import com.needle.FsoFso.search.service.SearchService;

@Controller
public class SearchController {

	private final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	private final SearchService searchService;

	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}

	@GetMapping("searchList.do")
	public String searchtList(Model model, SearchParamDto searchParamDto) {
		logger.info("MainController mainFunc()" + new Date());
		int pageNumber = searchParamDto.getPageNumber();
		int startNum = 1 + pageNumber * 12;
		int endNum = (pageNumber + 1) * 12;
		
		searchParamDto.setStartNum(startNum);
		searchParamDto.setEndNum(endNum);
		
		List<SearchDto> searchList = searchService.searchList(searchParamDto);
		int totalCount = searchService.getSearchListCount(searchParamDto);
		
		int searchPage = totalCount / 12;
		if (searchPage % 12 > 0) {
			searchPage = searchPage + 1;
		}
		
		model.addAttribute("searchList", searchList);
		model.addAttribute("searchPage", searchPage);
		model.addAttribute("pageNumber", searchParamDto.getPageNumber());
		model.addAttribute("keyWord", searchParamDto.getKeyWord());

		return "searchList.tiles";
	}
}