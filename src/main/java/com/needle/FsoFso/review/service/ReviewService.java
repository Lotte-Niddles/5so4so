package com.needle.FsoFso.review.service;

import java.util.List;

import com.needle.FsoFso.review.dto.ReviewDto;

public interface ReviewService {
	List<ReviewDto> findReviewsByProductId(long productId);
}
