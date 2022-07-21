package com.needle.FsoFso.order.repository.mybatis;

import com.needle.FsoFso.order.dto.OrderProduct.OrderProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderProductMapper {

    void save(OrderProduct orderProduct);
}
