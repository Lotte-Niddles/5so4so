package com.needle.FsoFso.product.dao;

import java.util.List;

import com.needle.FsoFso.product.dto.CartDto;
import com.needle.FsoFso.product.dto.ProductDto;

public interface ProductDao {

	List<ProductDto> productList();
	
	List<ProductDto> getproducPagelist(int start);
	
	int getAllProduct();
	
	ProductDto getProductById(long id);
	
	void addCart(CartDto cart);
}
