package com.needle.FsoFso.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.needle.FsoFso.review.dto.ReviewDto;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	private static final String NAME_SPACE = "Review.";

	private final SqlSession session;

	public ReviewDaoImpl(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<ReviewDto> findReviewsByProductId(long productId) {
		return session.selectList(NAME_SPACE + "findReviewsByProductId", productId);
	}

}
