package com.needle.FsoFso.order.dto.Order;

public class OrderSearchCond {

    private Long maxPrice;

    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public OrderSearchCond(Long totalPrice) {
        this.maxPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderSearchCond{" +
                "totalPrice=" + maxPrice +
                '}';
    }
}
