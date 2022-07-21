package com.needle.FsoFso.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderProductDto;
import com.needle.FsoFso.admin.dto.AdminProductDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;
import com.needle.FsoFso.admin.service.AdminService;
import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.product.service.ProductService;

@Controller
public class AdminController {

	private final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService service;
	
	@Autowired ProductService productService;

	@RequestMapping(value = "admin.do", method = RequestMethod.GET)
	public String adminWeekStatus(Model model) {
		logger.info("AdminController adminMain() " + new Date());
		AdminMainRequestDto dto = service.adminWeekStatusRequest();
		model.addAttribute("adminMainDto", dto);
		return "admin.tiles";
	}

	@RequestMapping(value = "adminProductList.do", method = RequestMethod.GET)
	public String adminProductList(Model model) {
		logger.info("AdminController adminProductList() " + new Date());
		AdminProductListRequestDto dto = service.adminProductListRequest();
		model.addAttribute("productListDto", dto);
		return "adminProductList.tiles";
	}

	@RequestMapping(value = "adminMemberList.do", method = RequestMethod.GET)
	public String adminMemberList(Model model) {
		logger.info("AdminController adminMemberList() " + new Date());
		AdminMemberListRequestDto dto = service.adminMemberListRequest();
		model.addAttribute("MemberListDto", dto);
		return "adminMemberList.tiles";
	}

	@GetMapping("/orderProductList.do")
	public String orderProductList(@RequestParam(value = "orderId", required = true) long orderId, Model model) {

		List<AdminOrderProductDto> orderProductList = service.findOrderProductsByOrderId(orderId);
		List<ProductDto> productList = new ArrayList<ProductDto>();
		for (AdminOrderProductDto dto : orderProductList) {
			productList.add(productService.getProductById(dto.getProductId()));
		}
		
		model.addAttribute("orderProductList", orderProductList);
		model.addAttribute("productList", productList);

		return "adminOrderProduct.tiles";
	}
}
