package com.needle.FsoFso.order.repository;

import com.needle.FsoFso.order.dto.OrderProduct.OrderProduct;
import com.needle.FsoFso.order.repository.mybatis.OrderProductMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderProductRepository {

    private final OrderProductMapper orderProductMapper;

    public OrderProductRepository(OrderProductMapper orderProductMapper) {
        this.orderProductMapper = orderProductMapper;
    }

    public void save(OrderProduct orderProduct){
        orderProductMapper.save(orderProduct);
    }
}
