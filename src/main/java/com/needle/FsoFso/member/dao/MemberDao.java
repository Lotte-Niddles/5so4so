package com.needle.FsoFso.member.dao;

import com.needle.FsoFso.member.service.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberDao {

    private static final String NAME_SPACE = "Member.";

    private final SqlSession session;

    public MemberDao(SqlSession session) {
        this.session = session;
    }

    public void save(Member member) {
        session.insert(NAME_SPACE + "save", member);
    }

    public Optional<Member> findByProviderId(Long providerId) {
        return Optional.ofNullable(session.selectOne(NAME_SPACE + "findByProviderId", providerId));
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(session.selectOne(NAME_SPACE + "findById", id));
    }
    
}
