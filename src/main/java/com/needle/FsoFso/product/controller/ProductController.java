package com.needle.FsoFso.product.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.product.services.ProductService;

@Controller
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService service;

	@RequestMapping(value = "productList.do", method = RequestMethod.GET)
	public String productList(Model model, HttpServletRequest req) {
		logger.info("ProductController mainFunc()" + new Date());
		req.getSession().setAttribute("loginId", "aaa"); // 로그인 했다고 가졍하기위해서 session에 id set;

		List<ProductDto> list = service.productList();
		model.addAttribute("productList", list);

		return "productList.tiles";
	}
	
	//	지훈 detail test
	@RequestMapping(value = "productDetail.do", method = RequestMethod.GET)
	public String productDetail(Model model, HttpServletRequest req) {
		logger.info("ProductController productDetail()" + new Date());
		req.getSession().setAttribute("loginId", "aaa"); // 로그인 했다고 가졍하기위해서 session에 id set;

		String sid = req.getParameter("id");
		
		if(sid.equals("") || sid == null) {
			return "productList.tiles";
		}
		else {
			int id = Integer.parseInt(sid);
			model.addAttribute("id", id);
		}
		return "productDetail.tiles";
	}
}
