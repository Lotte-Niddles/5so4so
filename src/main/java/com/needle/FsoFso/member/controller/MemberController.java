package com.needle.FsoFso.member.controller;

import com.needle.FsoFso.common.util.AttributeContainer;
import com.needle.FsoFso.review.dto.ReviewDto;
import com.needle.FsoFso.member.kakao.dto.KakaoOauthInfo;
import com.needle.FsoFso.member.service.Member;
import com.needle.FsoFso.member.service.MemberService;
import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.product.service.ProductService;
import com.needle.FsoFso.review.dto.Review;
import com.needle.FsoFso.review.service.ReviewService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PropertySource("classpath:sub-properties/oauth.properties")
public class MemberController {

    private final MemberService memberService;
    private final ReviewService reviewService;
    private final ProductService productService;
    private final KakaoOauthInfo kakaoOauthInfo;
    private final AdminMembers adminMembers;

    public MemberController(MemberService memberService, ReviewService reviewService,
            ProductService productService, KakaoOauthInfo kakaoOauthInfo,
            AdminMembers adminMembers) {
        this.memberService = memberService;
        this.reviewService = reviewService;
        this.productService = productService;
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

    @GetMapping("/exit.do")
    public String exit(HttpServletRequest request) {
        if (!AttributeContainer.hasSessionAttributeOf(request, "member")) {
            return "redirect:/productList.do";
        }
        final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");

        final Long exit = memberService.exit(member);
        request.getSession().removeAttribute("member");

        return "redirect:/productList.do";
    }

    @GetMapping("/me.do")
    public String showMyOrders(Model model, HttpServletRequest request) {
        if (!AttributeContainer.hasSessionAttributeOf(request, "member")) {
            return "redirect:/productList.do";
        }
        final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");

        List<ReviewDto> reviewList = reviewService.findReviewsByMemberId(member.getId());

        model.addAttribute("reviewList", reviewList);
        return "mypage.tiles";
    }

    @PostMapping("/me.do")
    public String updateNickname(HttpServletRequest request) {
        if (!AttributeContainer.hasSessionAttributeOf(request, "member")) {
            return "redirect:/productList.do";
        }

        final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");
        String nickname = request.getParameter("nickname");

        final Member updatedMember = new Member(member, nickname);
        memberService.updateMemberById(updatedMember);

        request.getSession().setAttribute("member", updatedMember);
        return "redirect:/me.do";
    }
}
