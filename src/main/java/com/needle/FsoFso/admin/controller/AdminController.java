package com.needle.FsoFso.admin.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.needle.FsoFso.admin.dto.AdminMainRequestDto;
import com.needle.FsoFso.admin.dto.AdminMemberListRequestDto;
import com.needle.FsoFso.admin.dto.AdminProductListRequestDto;
import com.needle.FsoFso.admin.service.AdminService;

@Controller
public class AdminController {
	
	private final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService service;

	@RequestMapping(value="admin.do")
	public String adminMain(Model model) {
		logger.info("AdminController adminMain() " + new Date());
		AdminMainRequestDto dto = service.adminMain();
		model.addAttribute("adminMainDto", dto);
		return "admin.tiles";
	}
	
	@RequestMapping(value="adminProductList.do")
	public String adminProductList(Model model) {
		logger.info("AdminController adminProductList() " + new Date());
		AdminProductListRequestDto dto = service.adminProductListRequest();
		model.addAttribute("productListDto", dto);
		return "adminProductList.tiles";
	}
	
	@RequestMapping(value="adminMemberList.do")
	public String adminMemberList(Model model) {
		logger.info("AdminController adminMemberList() " + new Date());
		AdminMemberListRequestDto dto = service.adminMemberListRequest();
		model.addAttribute("MemberListDto", dto);
		return "adminMemberList.tiles";
	}
}
