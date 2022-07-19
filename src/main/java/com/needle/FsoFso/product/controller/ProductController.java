package com.needle.FsoFso.product.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.product.services.ProductService;

@Controller
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("productList.do")
	public String productList(Model model, HttpServletRequest req) {
		logger.info("MainController mainFunc()" + new Date());
		// TODO : 로그인 했다고 가졍하기위해서 session에 id set;
		req.getSession().setAttribute("loginId", "aaa");

		List<ProductDto> productList = productService.productList();
		model.addAttribute("productList", productList);

		return "productList.tiles";
	}
	
	// TODO : 지훈 detail test
	@GetMapping("productDetail.do")
	public String productDetail(Model model, HttpServletRequest req) {
		logger.info("ProductController productDetail()" + new Date());
		// TODO : 로그인 했다고 가졍하기위해서 session에 id set;
		req.getSession().setAttribute("loginId", "aaa");

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
