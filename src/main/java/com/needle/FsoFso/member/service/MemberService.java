package com.needle.FsoFso.member.service;

import com.needle.FsoFso.member.dao.MemberDao;
import com.needle.FsoFso.member.kakao.KakaoClient;
import com.needle.FsoFso.member.kakao.dto.KakaoUserInfo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final KakaoClient kakaoClient;
    private final MemberDao memberDao;

    public MemberService(KakaoClient kakaoClient, MemberDao memberDao) {
        this.kakaoClient = kakaoClient;
        this.memberDao = memberDao;
    }

    public Member login(String code) {
        final KakaoUserInfo kakaoUserInfo = kakaoClient.kakaoInfo(code);

        return memberDao.findByProviderId(kakaoUserInfo.getProviderId())
                .orElseGet(() -> {
                    final Member member = new Member(
                            kakaoUserInfo.getProviderId(),
                            kakaoUserInfo.getNickname(),
                            kakaoUserInfo.getGender(),
                            kakaoUserInfo.getAgeRange()
                    );
                    memberDao.save(member);
                    return member;
                });
    }

    public boolean logout(Long id) {
        final Optional<Member> member = memberDao.findById(id);
        if (member.isEmpty()) {
            return false;
        }
        final Long unlinkedId = kakaoClient.unlink(member.get());
        return unlinkedId.equals(member.get().getProviderId());
    }
}
