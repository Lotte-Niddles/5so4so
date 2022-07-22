package com.needle.FsoFso.order.dto.Order;

/**
 * 결제 완료 페이지에 보여줄 상품 정보
 */
public class OrderSuccessDto {

    private Long quantity;
    private String name;
    private Long price;
    private String imgSrc;

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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public String toString() {
        return "OrderSuccessDto{" +
                "quantity=" + quantity +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }

    public OrderSuccessDto(Long quantity, String name, Long price, String imgSrc) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.imgSrc = imgSrc;
    }
}
