package com.needle.FsoFso.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.needle.FsoFso.review.dao.ReviewDao;
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

}
