package com.needle.FsoFso.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.needle.FsoFso.admin.dao.SellerProductDao;
import com.needle.FsoFso.admin.dto.SellerProductDto;

public interface SellerProductService {

	public int addProduct(SellerProductDto productDto);
	
	List<SellerProductDto> getAllProduct();
}
