package com.needle.FsoFso.order.dto;

import java.time.Instant;
import java.util.List;

public class OrderResponse {

    private Long id;
    private Long memberId;
    private Integer totalPrice;
    private Instant orderedAt;
    private Instant updatedAt;

    List<OrderProductResponse> orderProducts;

    public OrderResponse() {
    }

    public OrderResponse(Long id, Long memberId, Integer totalPrice, Instant orderedAt,
            Instant updatedAt,
            List<OrderProductResponse> orderProducts) {
        this.id = id;
        this.memberId = memberId;
        this.totalPrice = totalPrice;
        this.orderedAt = orderedAt;
        this.updatedAt = updatedAt;
        this.orderProducts = orderProducts;
    }

    public Long getFirstProduct() {
        return orderProducts.get(0).getProductId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Instant getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Instant orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<OrderProductResponse> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(
            List<OrderProductResponse> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
