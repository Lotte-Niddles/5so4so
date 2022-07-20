package com.needle.FsoFso.product.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String productList(Integer pageNumber, Model model, HttpServletRequest req) {
		logger.info("ProductController productList()" + new Date());
		// TODO : 로그인 했다고 가졍하기위해서 session에 id set;
		String pageNumber1 = req.getParameter("pageNumber");
		req.getSession().setAttribute("loginId", "aaa");
		
		int start = 1;
		
		if(pageNumber != null) {
			start = 1 + 12 * pageNumber;
		}
		
		List<ProductDto> productList = productService.getproducPagelist(start);
		int len = productService.getAllProduct();
		
		model.addAttribute("productList", productList);
		model.addAttribute("len", len);
		model.addAttribute("pageNumber", pageNumber1);
		return "productList.tiles"; 
	}
	
	// TODO : 지훈 detail test
	@GetMapping("productDetail.do")
	public String productDetail(Model model, HttpServletRequest req,
			@RequestParam(value = "id",required = true) int productId) {
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
		
		System.out.println(productId);
		ProductDto product = productService.getProductById(productId);
		model.addAttribute("product",product);
		System.out.println(product.toString());
		return "productDetail.tiles";
	}
}
