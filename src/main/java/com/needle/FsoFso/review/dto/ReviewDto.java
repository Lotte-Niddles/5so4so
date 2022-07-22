package com.needle.FsoFso.review.dto;

import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.review.dto.Review;
import java.time.Instant;

public class ReviewDto {

    private Long id;
    private Long memberId;

    private String content;
    private Instant createdAt;
    private Instant updatedAt;

    private Long productId;
    private String name;
    private String thumbnailUrl;

    public ReviewDto() {
    }

    public ReviewDto(Review review, ProductDto productDto) {
        this(
                review.getId(),
                review.getMemberId(),
                review.getContent(),
                review.getCreatedAt(),
                review.getUpdatedAt(),
                review.getProductId(),
                productDto.getName(),
                productDto.getthumbnailUrl()
        );
    }

    public ReviewDto(Long id, Long memberId, String content, Instant createdAt,
            Instant updatedAt,
            Long productId, String name, String thumbnailUrl) {
        this.id = id;
        this.memberId = memberId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productId = productId;
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getContent() {
        return content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
