package com.needle.FsoFso.search.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.needle.FsoFso.search.dto.SearchDto;
import com.needle.FsoFso.search.service.SearchService;

@Controller
public class SearchController {

	private final Logger logger = LoggerFactory.getLogger(SearchController.class);
	private final SearchService searchService;

	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}

	@GetMapping("searchList.do")
	public String searchtList(Model model, HttpServletRequest req) {
		logger.info("MainController mainFunc()" + new Date());
		String keyWord = req.getParameter("keyWord");
		String choice = req.getParameter("choice");
//		String search = req.getParameter("search");
		String spage = req.getParameter("pageNumber");
		
		int page = 0;
		if(spage != null && !spage.equals("")) {
			page = Integer.parseInt(spage);
		}
		if(choice == null) {
			choice = "";
		}
		if(keyWord == null) {
			keyWord = "";
		}

		List<SearchDto> searchList = searchService.searchList(keyWord);
		model.addAttribute("searchList" ,searchList);
		
		return "searchList.tiles";
	}
}