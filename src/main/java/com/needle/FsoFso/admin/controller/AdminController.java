package com.needle.FsoFso.admin.controller;

import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderListRequestDto;
import com.needle.FsoFso.admin.dto.AdminOrderProductListRequestDto;
import com.needle.FsoFso.admin.dto.AdminProductDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;
import com.needle.FsoFso.admin.dto.AgeChartDto;
import com.needle.FsoFso.admin.dto.GenderChartDto;
import com.needle.FsoFso.admin.service.AdminService;
import com.needle.FsoFso.common.aop.AdminOnly;
import com.needle.FsoFso.product.service.ProductService;
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

@Controller
public class AdminController {

	private final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService service;

	@Autowired
	ProductService productService;

	@AdminOnly
	@RequestMapping(value = "admin.do", method = RequestMethod.GET)
	public String adminWeekStatus(Model model){

		logger.info("AdminController adminWeekStatus() " + new Date());

		AdminMainRequestDto dto = service.adminWeekStatusRequest();
		List<GenderChartDto> genderDtoList = service.findGenderCount();
		List<AgeChartDto> ageChartDtoList = service.findAgeCount();

		model.addAttribute("adminMainDto", dto);
		model.addAttribute("genderDtoList", genderDtoList);
		model.addAttribute("ageChartDtoList", ageChartDtoList);
		return "admin.tiles";
	}

	@AdminOnly
	@RequestMapping(value = "adminProductList.do", method = RequestMethod.GET)
	public String adminProductList(Model model, AdminProductDto adminProductDto) {
		logger.info("AdminController adminProductList() " + new Date());
		AdminProductListRequestDto productListDto = service.adminProductListRequest(adminProductDto);

		model.addAttribute("productListDto", productListDto);

		return "adminProductList.tiles";
	}

	@AdminOnly
	@RequestMapping(value = "adminMemberList.do", method = RequestMethod.GET)
	public String adminMemberList(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
		logger.info("AdminController adminMemberList() " + new Date());
		keyword = keyword == null ? "" : keyword;
		AdminMemberListRequestDto dto = service.adminMemberListRequest(keyword);
		model.addAttribute("MemberListDto", dto);
		return "adminMemberList.tiles";
	}

	@AdminOnly
	@RequestMapping(value = "adminAddProduct.do", method = RequestMethod.GET)
	public String adminAddProduct(Model model) {

		logger.info("AdminController adminAddProduct() " + new Date());

		return "redirect:/seller/product.do";
	}

	@AdminOnly
	@RequestMapping(value = "adminOrderList.do", method = RequestMethod.GET)
	public String adminOrderList(Model model, @RequestParam(value = "keyWord", required = false) Long keyWord) {

		logger.info("AdminController adminOrderList() " + new Date());
		keyWord = keyWord == null ? -1 : keyWord;

		AdminOrderListRequestDto dto = service.adminOrderListRequest(keyWord);
		model.addAttribute("OrderListDto", dto);
		return "adminOrderList.tiles";
	}

	@AdminOnly
	@GetMapping("adminOrderProductList.do")
	public String adminOrderProductList(@RequestParam(value = "orderId", required = true) long orderId, Model model) {

		logger.info("AdminController orderProductList() " + new Date());

		AdminOrderProductListRequestDto dto = service.findOrderProductsByOrderId(orderId);
		model.addAttribute("orderProductListDto", dto);

		return "adminOrderProductList.tiles";
	}
}
