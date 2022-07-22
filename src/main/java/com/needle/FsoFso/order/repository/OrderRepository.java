package com.needle.FsoFso.order.repository;

import com.needle.FsoFso.order.domain.Order;
import com.needle.FsoFso.order.dto.Order.OrderSearchCond;
import com.needle.FsoFso.order.repository.mybatis.OrderMapper;
import com.needle.FsoFso.order.dto.OrderResponse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    private final OrderMapper orderMapper;

    public OrderRepository(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public Long save(Order order) {
        orderMapper.orderSave(order);
        return order.getId();
    }

    public Optional<Order> findById(Long id) {
        return orderMapper.orderFindById(id);
    }

    public List<Order> findOrders(OrderSearchCond orderSearchCond) {
        return orderMapper.findOrders(orderSearchCond);
    }

    public List<OrderResponse> findByMemberId(Long id) {
        return orderMapper.findByMemberId(id);
    }
}
