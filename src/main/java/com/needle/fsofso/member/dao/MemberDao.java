package com.needle.fsofso.member.dao;

import com.needle.fsofso.member.service.Member;
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
}
