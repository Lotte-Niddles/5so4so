package com.needle.FsoFso.review.service;

import com.needle.FsoFso.review.dto.ReviewDto;
import java.util.List;

import com.needle.FsoFso.review.dto.MemberProductDto;
import com.needle.FsoFso.review.dto.Review;

public interface ReviewService {
	List<Review> findReviewsByProductId(long productId);

	void save(Review review);

	int getCountByUserIdProductId(MemberProductDto memberProductDto);

	List<ReviewDto> findReviewsByMemberId(long memberId);
}
