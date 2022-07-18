package com.needle.fsofso.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final KakaoClient kakaoClient;

    public MemberService(KakaoClient kakaoClient) {
        this.kakaoClient = kakaoClient;
    }


    public void kakaoLogin(String code) {
        kakaoClient.kakaoInfo(code);
    }
}
