package com.needle.FsoFso.product.service;

import com.needle.FsoFso.product.dto.CartDto;
import java.util.List;

import com.needle.FsoFso.product.dto.ProductDto;

public interface ProductService {
	
	List<ProductDto> productList();
	
	List<ProductDto> getproducPagelist(int start);
	
	int getAllProductCount();

	ProductDto getProductById(int id);

	void addCart(CartDto cart);
}