package com.needle.FsoFso.order.domain;


import java.time.Instant;

public class Order {

    private Long id;
    private Long memberId;
    private Long totalPrice;
    private Instant updateAt;
    private Instant orderAt;

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

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public Instant getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(Instant orderAt) {
        this.orderAt = orderAt;
    }

    public Order(Long memberId, Long totalPrice) {
        this.memberId = memberId;
        this.totalPrice = totalPrice;
    }

    public Order(Long id, Long memberId, Long totalPrice, Instant updateAt, Instant orderAt) {
        this.id = id;
        this.memberId = memberId;
        this.totalPrice = totalPrice;
        this.updateAt = updateAt;
        this.orderAt = orderAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", totalPrice=" + totalPrice +
                ", updateAt=" + updateAt +
                ", orderAt=" + orderAt +
                '}';
    }
}
