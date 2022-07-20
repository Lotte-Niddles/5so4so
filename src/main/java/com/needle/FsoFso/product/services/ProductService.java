package com.needle.FsoFso.product.services;

import java.util.List;

import com.needle.FsoFso.product.dto.ProductDto;

public interface ProductService {
	
	List<ProductDto> productList();
	
	List<ProductDto> getproducPagelist(int start);
	
	int getAllProduct();
	
	ProductDto getProductById(int id);
}
