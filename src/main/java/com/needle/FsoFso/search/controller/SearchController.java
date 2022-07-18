package com.needle.FsoFso.search.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {
	Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping(value = "searchList.do", method = RequestMethod.GET)
	public String searchtList(Model model, HttpServletRequest req) {
		logger.info("MainController mainFunc()" + new Date());
		
		
		
		return "searchList.tiles";
		
	}

}
