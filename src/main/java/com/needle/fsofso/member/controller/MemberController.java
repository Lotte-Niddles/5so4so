package com.needle.fsofso.member.controller;

import com.needle.fsofso.member.kakao.dto.KakaoOauthInfo;
import com.needle.fsofso.member.service.Member;
import com.needle.fsofso.member.service.MemberService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String oauthRedirect(String code, HttpServletRequest request) {
        final Member member = memberService.login(code);
        request.getSession().setAttribute("member", member);
        return "main";
    }

    @GetMapping("/logout.do")
    public String logout(Long id, HttpServletRequest request) {
        final boolean logout = memberService.logout(id);
        if (logout) {
            request.getSession().removeAttribute("member");
        }
        return "logout";
    }
}
