package com.needle.FsoFso.order.dto.Shop;

/**
 * 장바구니 상품 조회 DTO
 */
public class ShopDto {

    private Long id;
    private Long memberId;
    private Long productId;
    private Long quantity;
    private String name;
    private Long price;
    private Long stock;
    private String imgSrc;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public ShopDto(Long id, Long memberId, Long productId, Long quantity, String name, Long price, Long stock, String imgSrc) {
        this.id = id;
        this.memberId = memberId;
        this.productId = productId;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.imgSrc = imgSrc;
    }

    @Override
    public String toString() {
        return "ShopDto{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }
}
