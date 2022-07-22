package com.needle.FsoFso.order.dto.Shop;

/**
 * 이미지, 상품명, 가격, 수량
 */
public class DisplayShopDto {

    private Long id;
    private Long productId;
    private String imageSrc;
    private String itemName;
    private String quantity;
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public DisplayShopDto(Long id, Long productId, String imageSrc, String itemName, String quantity, Long price) {
        this.id = id;
        this.productId = productId;
        this.imageSrc = imageSrc;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "DisplayShopDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", imageSrc='" + imageSrc + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price=" + price +
                '}';
    }
}
