package com.needle.FsoFso.order.dto.Order;

public class OrderUpdateDto {

    private Long totalPrice;

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderUpdateDto(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
