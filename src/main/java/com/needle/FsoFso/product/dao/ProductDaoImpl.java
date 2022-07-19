package com.needle.FsoFso.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.needle.FsoFso.product.dto.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	private static final String NAME_SPACE = "Product.";
	
	private final SqlSession session;
	
	public ProductDaoImpl(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<ProductDto> productList() {
		return session.selectList(NAME_SPACE + "productList");
	}
}
