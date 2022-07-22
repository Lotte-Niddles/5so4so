package com.needle.FsoFso.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.needle.FsoFso.product.dto.CartDto;
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

	@Override
	public List<ProductDto> getproducPagelist(int start) {
		return session.selectList(NAME_SPACE + "getproducPagelist", start);
	}

	@Override
	public int getAllProduct() {
		return session.selectOne(NAME_SPACE + "getAllProduct");
	}

	@Override
	public ProductDto getProductById(long id) {
		return session.selectOne(NAME_SPACE + "getProductById",id);
	}

	@Override
	public void addCart(CartDto cart) {
		session.insert(NAME_SPACE + "addCart", cart);
	}
	
	@Override
	public int checkCart(CartDto cart) {
		return session.selectOne(NAME_SPACE + "checkCart", cart);
	}

	@Override
	public void removeProductById(long productId) {
		session.delete(NAME_SPACE + "removeProductById", productId);
	}

	@Override
	public void removeCartByMemberIdProductId(CartDto cartDto) {
		session.delete(NAME_SPACE + "removeCartByMemberIdProductId", cartDto);
	}
	
}
