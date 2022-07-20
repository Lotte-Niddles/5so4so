package com.needle.FsoFso.member.controller;

import com.needle.FsoFso.member.kakao.dto.KakaoOauthInfo;
import com.needle.FsoFso.member.service.Member;
import com.needle.FsoFso.member.service.MemberService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource("classpath:sub-properties/oauth.properties")
public class MemberController {

    private final MemberService memberService;
    private final KakaoOauthInfo kakaoOauthInfo;
    private final AdminMembers adminMembers;

    public MemberController(MemberService memberService, KakaoOauthInfo kakaoOauthInfo,
            AdminMembers adminMembers) {
        this.memberService = memberService;
        this.kakaoOauthInfo = kakaoOauthInfo;
        this.adminMembers = adminMembers;
    }

    @GetMapping("/login.do")
    public String login(Model model) {
        model.addAttribute("kakaoInfo", kakaoOauthInfo);
        return "login.tiles";
    }

    @GetMapping("/oauth.do")
    public String oauthRedirect(String code, HttpServletRequest request) {
        final Member member = memberService.login(code);
        request.getSession().setAttribute("member", member);

        final List<String> adminUsers = adminMembers.getAdminUsers();
        if (adminUsers.contains(member.getProviderId().toString())) {
            return "redirect:/admin.do";
        }

        return "redirect:/productList.do";
    }

    @GetMapping("/logout.do")
    public String logout(Long id, HttpServletRequest request) {
        final boolean logout = memberService.logout(id);
        if (logout) {
            request.getSession().removeAttribute("member");
        }
        return "redirect:/productList.do";
    }
}
