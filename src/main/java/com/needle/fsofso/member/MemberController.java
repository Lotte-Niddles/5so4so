package com.needle.fsofso.member;

import com.needle.fsofso.member.kakao.dto.KakaoOauthInfo;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource("classpath:properties/oauth.properties")
public class MemberController {

    private final MemberService memberService;
    private final KakaoOauthInfo kakaoOauthInfo;

    public MemberController(MemberService memberService, KakaoOauthInfo kakaoOauthInfo) {
        this.memberService = memberService;
        this.kakaoOauthInfo = kakaoOauthInfo;
    }

    @GetMapping("/login.do")
    public String login(Model model) {
        model.addAttribute("kakaoInfo", kakaoOauthInfo);
        return "login";
    }

    @GetMapping("/oauth.do")
    public void oauthRedirect(String code) {
        memberService.kakaoLogin(code);
    }
}
