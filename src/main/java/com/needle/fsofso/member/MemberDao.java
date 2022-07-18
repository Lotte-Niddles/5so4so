package com.needle.fsofso.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
}
