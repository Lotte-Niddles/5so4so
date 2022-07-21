package com.needle.FsoFso.admin.controller;

import java.util.Date;
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
import com.needle.FsoFso.admin.dto.AdminOrderProductListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderListRequestDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;
import com.needle.FsoFso.admin.service.AdminService;
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
	
	@RequestMapping(value = "adminAddProduct.do", method = RequestMethod.GET)
	public String adminAddProduct(Model model) {
		
		logger.info("AdminController adminAddProduct() " + new Date());

		return "redirect:/seller/product.do";
	}
	
	@RequestMapping(value="adminOrderList.do", method = RequestMethod.GET)
	public String adminOrderList(Model model) {
		
		logger.info("AdminController adminOrderList() " + new Date());
		
		AdminOrderListRequestDto dto = service.adminOrderListRequest();
		model.addAttribute("OrderListDto", dto);
		return "adminOrderList.tiles";
	}

	@GetMapping("adminOrderProductList.do")
	public String adminOrderProductList(@RequestParam(value = "orderId", required = true) long orderId, Model model) {
		
		logger.info("AdminController orderProductList() " + new Date());
		
		AdminOrderProductListRequestDto dto = service.findOrderProductsByOrderId(orderId);
		model.addAttribute("orderProductListDto", dto);

		return "adminOrderProductList.tiles";
	}
}
