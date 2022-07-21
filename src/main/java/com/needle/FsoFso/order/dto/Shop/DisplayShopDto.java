package com.needle.FsoFso.order.dto.Shop;

/**
 이미지, 상품명, 가격,
 */
public class DisplayShopDto {

    private Long id;
    private String imageSrc;
    private String itemName;
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public DisplayShopDto(Long id, String imageSrc, String itemName, Long price) {
        this.id = id;
        this.imageSrc = imageSrc;
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "DisplayShopDto{" +
                "id=" + id +
                ", imageSrc='" + imageSrc + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
