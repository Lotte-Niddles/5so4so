package com.needle.FsoFso.admin.controller;

import com.needle.FsoFso.common.aop.AdminOnly;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.needle.FsoFso.admin.dto.SellerProductDto;
import com.needle.FsoFso.admin.service.SellerProductService;
import com.needle.FsoFso.admin.util.FTPUtil;

@Controller
@RequestMapping(path = "/seller")
public class SellerProductController {
	
	@Autowired
	private FTPUtil ftpUtil;
	
	@Autowired
	private SellerProductService sellerProductService;

	@AdminOnly
	@RequestMapping(value = "/product.do", method = RequestMethod.POST)
	public String addSellerProduct(SellerProductDto sellerProductDto,
			@RequestParam(value = "fileload", required = false) MultipartFile fileload,
			HttpServletRequest req) {
		
		String filePath = ftpUtil.getFilePath();
		String fileName = ftpUtil.getFileName();
		sellerProductDto.setThumbnailUrl(filePath + fileName);
		
		if(ftpUtil.uploadImage(fileload,fileName)) {
			sellerProductService.addProduct(sellerProductDto);
		}
		
		return "redirect:/adminProductList.do";
	}

	@AdminOnly
	@RequestMapping(value = "/product.do", method = RequestMethod.GET)
	public String getAllProduct(Model model) {
		
		List<SellerProductDto> productList = sellerProductService.getAllProduct();
		model.addAttribute("productList",productList);
		
		return "adminAddProduct.tiles";
	}
	
}
