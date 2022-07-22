package com.needle.FsoFso.order.repository.mybatis;

import com.needle.FsoFso.order.domain.Order;
import com.needle.FsoFso.order.dto.Order.OrderSearchCond;
import com.needle.FsoFso.order.dto.Order.OrderUpdateDto;
import com.needle.FsoFso.order.dto.OrderResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrderMapper {

    Long orderSave(Order order);

    Optional<Order> orderFindById(Long id);

    List<Order> findUserChoiceProductId(OrderSearchCond orderSearch);

    List<Order> findOrders(OrderSearchCond orderSearchCond);

    List<OrderResponse> findByMemberId(Long id);

    /**
     * member의 id와 Orders의 member_id는 변경될 수 없습니다.
     * 그러므로 Orders의 total_price만 변경할 수 있는 update를 구현하였습니다.
     */
    void updateOrderPrice(@Param("id") Long id, @Param("updateParam") OrderUpdateDto updateParam);
}
