package com.needle.FsoFso.review.dao;

import com.needle.FsoFso.review.dto.ReviewDto;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.needle.FsoFso.review.dto.MemberProductDto;
import com.needle.FsoFso.review.dto.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	private static final String NAME_SPACE = "Review.";

	private final SqlSession session;

	public ReviewDaoImpl(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Review> findReviewsByProductId(long productId) {
		return session.selectList(NAME_SPACE + "findReviewsByProductId", productId);
	}

	@Override
	public void save(Review review) {
		session.insert(NAME_SPACE + "save", review);
	}

	@Override
	public int getCountByUserIdProductId(MemberProductDto memberProductDto) {
		return session.selectOne(NAME_SPACE + "getCountByUserIdProductId", memberProductDto);
	}

	@Override
	public List<ReviewDto> findReviewsByMemberId(long memberId) {
		return session.selectList(NAME_SPACE + "findReviewsByMemberId", memberId);
	}
}
