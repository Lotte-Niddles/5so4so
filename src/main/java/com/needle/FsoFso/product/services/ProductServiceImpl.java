package com.needle.FsoFso.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needle.FsoFso.product.dao.ProductDao;
import com.needle.FsoFso.product.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;

	@Override
	public List<ProductDto> productList() {
		return dao.productList();
	}
	
}
