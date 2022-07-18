package com.needle.FsoFso.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.needle.FsoFso.product.dto.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SqlSession session;

	String ns = "Product.";

	@Override
	public List<ProductDto> productList() {
		return session.selectList(ns + "productList");
	}

}
