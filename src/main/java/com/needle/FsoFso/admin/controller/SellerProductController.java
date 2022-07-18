package com.needle.FsoFso.admin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
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
	FTPUtil ftpUtil;
	
	@Autowired
	SellerProductService sellerProductService;
	
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
		
		// TODO : 관리자 페이지로 이동하게 변경
		return "admin/addProduct";
	}
	
	@RequestMapping(value = "/product.do", method = RequestMethod.GET)
	public String getAllProduct(Model model) {
		
		List<SellerProductDto> productList = sellerProductService.getAllProduct();
		model.addAttribute(productList);
		
		for(SellerProductDto dto : productList) {
			System.out.println(dto.toString());
		}
		// TODO : 리스트를 볼 페이지로 이동하게 변경
		return "admin/addProduct";
	}
	
}
