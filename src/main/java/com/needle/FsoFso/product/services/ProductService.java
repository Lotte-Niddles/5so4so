package com.needle.FsoFso.product.services;

import java.util.List;

import com.needle.FsoFso.product.dto.ProductDto;

public interface ProductService {
	
	List<ProductDto> productList();
	int getProductId();
}
