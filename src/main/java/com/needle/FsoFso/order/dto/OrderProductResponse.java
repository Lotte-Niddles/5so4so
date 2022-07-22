package com.needle.FsoFso.order.dto;


public class OrderProductResponse {

    private Long orderProductId;
    private Long productId;
    private int quantity;
    private int unitPrice;

    private String name;
    private String thumbnailUrl;

    public OrderProductResponse() {
    }

    public OrderProductResponse(Long orderProductId, Long productId, int quantity, int unitPrice,
            String name, String thumbnailUrl) {
        this.orderProductId = orderProductId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
