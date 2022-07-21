package com.needle.FsoFso.order.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductsMapper {

    void updateProduct(@Param("productId") Long productId, @Param("orderQuantity") Long orderQuantity);

    Long findStock(Long ProductId);
}
