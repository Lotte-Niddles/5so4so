package com.needle.FsoFso.dsp.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DspController {
	Logger logger = LoggerFactory.getLogger(DspController.class);
	
	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public String mainFunc(HttpServletRequest req) {
		logger.info("DspController mainFunc() " + new Date());
		
		//req.getSession().setAttribute("loginId", "bcd");
		
		return "main.tiles";
	}
	
}
