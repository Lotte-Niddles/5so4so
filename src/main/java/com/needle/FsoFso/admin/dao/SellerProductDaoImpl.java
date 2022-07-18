package com.needle.FsoFso.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.needle.FsoFso.admin.dto.SellerProductDto;

@Repository
public class SellerProductDaoImpl implements SellerProductDao{

	@Autowired
	SqlSession session;
	
	String ns = "SellerProduct.";
	
	@Override
	public int addProduct(SellerProductDto productDto) {
		return session.insert(ns + "addProduct", productDto);
	}

	@Override
	public List<SellerProductDto> getAllProduct() {
		return session.selectList(ns + "getAllProduct");
	}

}
