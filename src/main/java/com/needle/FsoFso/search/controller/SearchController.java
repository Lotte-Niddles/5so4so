package com.needle.FsoFso.search.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {

	private final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@GetMapping("searchList.do")
	public String searchtList(Model model, HttpServletRequest req) {
		logger.info("MainController mainFunc()" + new Date());
		// TODO 검색 목록 작성 필요함

		return "searchList.tiles";
	}
}