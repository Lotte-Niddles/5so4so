package com.needle.FsoFso.review.service;

import java.util.List;

import com.needle.FsoFso.review.dto.MemberProductDto;
import com.needle.FsoFso.review.dto.ReviewDto;

public interface ReviewService {
	List<ReviewDto> findReviewsByProductId(long productId);

	void save(ReviewDto review);

	int getCountByUserIdProductId(MemberProductDto memberProductDto);

	List<ReviewDto> findReviewsByMemberId(long memberId);
}
