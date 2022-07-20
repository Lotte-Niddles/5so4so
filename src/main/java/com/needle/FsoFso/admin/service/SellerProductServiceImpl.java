package com.needle.FsoFso.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needle.FsoFso.admin.dao.SellerProductDao;
import com.needle.FsoFso.admin.dto.SellerProductDto;

@Service
public class SellerProductServiceImpl implements SellerProductService {

	@Autowired
	private SellerProductDao sellerProductDao;
	
	@Override
	public int addProduct(SellerProductDto productDto) {
		return sellerProductDao.addProduct(productDto);
	}

	@Override
	public List<SellerProductDto> getAllProduct() {
		return sellerProductDao.getAllProduct();
	}

	
}
