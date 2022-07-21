package com.needle.FsoFso.order.dto.Shop;

/**
 이미지, 상품명, 가격,
 */
public class DisplayShopDto {
    public String imageSrc;
    public String itemName;
    public Long price;

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

    public DisplayShopDto(String imageSrc, String itemName, Long price) {
        this.imageSrc = imageSrc;
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BasicShopDto{" +
                "imageSrc='" + imageSrc + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
