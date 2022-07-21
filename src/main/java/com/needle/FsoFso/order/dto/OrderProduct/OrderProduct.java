package com.needle.FsoFso.order.dto.OrderProduct;

import java.time.Instant;

public class OrderProduct {

    private Long id;
    private Long orderId;
    private Long memberId;
    private Long productId;
    private Long quantity;
    private Long unitPrice;
    private Instant orderedAt;
    private Instant updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
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

    public OrderProduct() {
    }

    public OrderProduct(Long id, Long orderId, Long memberId, Long productId, Long quantity, Long unitPrice, Instant orderedAt, Instant updatedAt) {
        this.id = id;
        this.orderId = orderId;
        this.memberId = memberId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.orderedAt = orderedAt;
        this.updatedAt = updatedAt;
    }

    public OrderProduct(Long orderId, Long memberId, Long productId, Long quantity, Long unitPrice) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", memberId=" + memberId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", orderedAt=" + orderedAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
