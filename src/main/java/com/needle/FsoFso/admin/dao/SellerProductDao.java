package com.needle.FsoFso.admin.dao;

import java.util.List;

import com.needle.FsoFso.admin.dto.SellerProductDto;

public interface SellerProductDao {
	
	int addProduct(SellerProductDto productDto);
	
	List<SellerProductDto> getAllProduct();
	
}
