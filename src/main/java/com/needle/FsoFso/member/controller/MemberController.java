package com.needle.FsoFso.member.controller;

import com.needle.FsoFso.member.kakao.dto.KakaoOauthInfo;
import com.needle.FsoFso.member.service.Member;
import com.needle.FsoFso.member.service.MemberService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource("classpath:sub-properties/oauth.properties")
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
        return "login.tiles";
    }

    @GetMapping("/oauth.do")
    public void oauthRedirect(String code, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        final Member member = memberService.login(code);
        request.getSession().setAttribute("member", member);

        response.sendRedirect("/productList.do");
    }

    @GetMapping("/logout.do")
    public void logout(Long id, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        final boolean logout = memberService.logout(id);
        if (logout) {
            request.getSession().removeAttribute("member");
        }
        response.sendRedirect("/productList.do");
    }
}
