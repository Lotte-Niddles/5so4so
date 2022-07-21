package com.needle.FsoFso.order.repository;

import com.needle.FsoFso.order.repository.mybatis.ProductsMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductsRepository {

    private final ProductsMapper productsMapper;

    public ProductsRepository(ProductsMapper productsMapper) {
        this.productsMapper = productsMapper;
    }

    public void updateStockProducts(Long productId, Long orderQuantity) {
        productsMapper.updateProduct(productId, orderQuantity);
    }

    public Long findStock(Long productId){
        return productsMapper.findStock(productId);
    }
}
