package com.needle.FsoFso.product.service;

import java.util.List;

import com.needle.FsoFso.product.dto.CartDto;
import com.needle.FsoFso.product.dto.ProductDto;

public interface ProductService {
	
	List<ProductDto> productList();
	
	List<ProductDto> getproducPagelist(int start);
	
	int getAllProductCount();
	
	ProductDto getProductById(long id);
	
	void addCart(CartDto cart);

	void removeProductById(long productId);

	void removeCartByMemberIdProductId(CartDto cartDto);
}
