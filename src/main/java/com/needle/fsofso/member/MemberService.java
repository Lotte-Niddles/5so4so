package com.needle.fsofso.member;

import com.needle.fsofso.member.kakao.KakaoClient;
import com.needle.fsofso.member.kakao.dto.KakaoUserInfo;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final KakaoClient kakaoClient;
    private final MemberDao memberDao;

    public MemberService(KakaoClient kakaoClient, MemberDao memberDao) {
        this.kakaoClient = kakaoClient;
        this.memberDao = memberDao;
    }

    public void kakaoLogin(String code) {
        final KakaoUserInfo kakaoUserInfo = kakaoClient.kakaoInfo(code);
        if (kakaoUserInfo.hasAgeRange()) {
            final Member member = new Member(kakaoUserInfo.getProviderId(), kakaoUserInfo.getNickname(), kakaoUserInfo.getAgeRange());
            memberDao.save(member);
            return;
        }
        final Member member = new Member(kakaoUserInfo.getProviderId(), kakaoUserInfo.getNickname(), null);
        memberDao.save(member);
    }
}
