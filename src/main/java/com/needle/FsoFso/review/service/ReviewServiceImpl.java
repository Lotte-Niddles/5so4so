package com.needle.FsoFso.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.needle.FsoFso.review.dao.ReviewDao;
import com.needle.FsoFso.review.dto.MemberProductDto;
import com.needle.FsoFso.review.dto.ReviewDto;

@Service
public class ReviewServiceImpl implements ReviewService{

	private final ReviewDao reviewDao;
	
	public ReviewServiceImpl(ReviewDao reviewDao){
		this.reviewDao = reviewDao;
	}
	
	@Override
	public List<ReviewDto> findReviewsByProductId(long productId) {
		return reviewDao.findReviewsByProductId(productId);
	}

	@Override
	public void save(ReviewDto review) {
		reviewDao.save(review);
	}

	@Override
	public int getCountByUserIdProductId(MemberProductDto memberProductDto) {
		return reviewDao.getCountByUserIdProductId(memberProductDto);
	}

	@Override
	public List<ReviewDto> findReviewsByMemberId(long memberId) {
		return reviewDao.findReviewsByMemberId(memberId);
	}

}
