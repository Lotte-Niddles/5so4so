package com.needle.FsoFso.review.dao;

import java.util.List;

import com.needle.FsoFso.review.dto.MemberProductDto;
import com.needle.FsoFso.review.dto.ReviewDto;

public interface ReviewDao {
	List<ReviewDto> findReviewsByProductId(long productId);

	void save(ReviewDto review);

	int getCountByUserIdProductId(MemberProductDto memberProductDto);
}
