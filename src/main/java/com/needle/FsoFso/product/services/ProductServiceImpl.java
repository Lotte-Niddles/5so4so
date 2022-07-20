package com.needle.FsoFso.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needle.FsoFso.product.dao.ProductDao;
import com.needle.FsoFso.product.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;

	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<ProductDto> productList() {
		return productDao.productList();
	}

	@Override
	public List<ProductDto> getproducPagelist(int start) {
		return productDao.getproducPagelist(start);
	}

	@Override
	public int getAllProduct() {
		return productDao.getAllProduct();
	}

	@Override
	public ProductDto getProductById(int id) {
		return productDao.getProductById(id);
	}
	
	
	
}
