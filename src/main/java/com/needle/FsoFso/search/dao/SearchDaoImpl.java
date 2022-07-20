package com.needle.FsoFso.search.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.needle.FsoFso.search.dto.SearchDto;

@Repository
public class SearchDaoImpl implements SearchDao {

	private static final String NAME_SPACE = "Search.";

	private final SqlSession session;

	public SearchDaoImpl(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<SearchDto> searchList(String keyWord) {
		return session.selectList(NAME_SPACE + "searchList", keyWord);
	}
}
