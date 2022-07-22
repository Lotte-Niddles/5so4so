package com.needle.FsoFso.member.controller;

import com.needle.FsoFso.common.aop.MemberOnly;
import com.needle.FsoFso.common.util.AttributeContainer;
import com.needle.FsoFso.member.controller.dto.NicknameRequest;
import com.needle.FsoFso.member.kakao.dto.KakaoOauthInfo;
import com.needle.FsoFso.member.service.Member;
import com.needle.FsoFso.member.service.MemberService;
import com.needle.FsoFso.order.dto.OrderResponse;
import com.needle.FsoFso.order.service.OrderService;
import com.needle.FsoFso.review.dto.ReviewDto;
import com.needle.FsoFso.review.service.ReviewService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@PropertySource("classpath:sub-properties/oauth.properties")
public class MemberController {

    private final MemberService memberService;
    private final ReviewService reviewService;
    private final OrderService orderService;
    private final KakaoOauthInfo kakaoOauthInfo;
    private final AdminMembers adminMembers;

    public MemberController(MemberService memberService, ReviewService reviewService,
            OrderService orderService, KakaoOauthInfo kakaoOauthInfo, AdminMembers adminMembers) {
        this.memberService = memberService;
        this.reviewService = reviewService;
        this.orderService = orderService;
        this.kakaoOauthInfo = kakaoOauthInfo;
        this.adminMembers = adminMembers;
    }

    @GetMapping("/login.do")
    public String login(Model model, HttpServletRequest request) {
        if (AttributeContainer.hasSessionAttributeOf(request, "member")) {
            final Member member = (Member) AttributeContainer.sessionAttributeFrom(request,
                    "member");

            final List<String> adminUsers = adminMembers.getAdminUsers();
            if (adminUsers.contains(member.getProviderId().toString())) {
                return "redirect:/admin.do";
            }

            return "redirect:/productList.do";
        }

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

    @MemberOnly
    @GetMapping("/logout.do")
    public String logout(Long id, HttpServletRequest request) {
        final boolean logout = memberService.logout(id);
        if (logout) {
            request.getSession().removeAttribute("member");
        }
        return "redirect:/productList.do";
    }

    @MemberOnly
    @GetMapping("/me.do")
    public String showMypage(Model model, HttpServletRequest request) {
        final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");

        List<ReviewDto> reviewList = reviewService.findReviewsByMemberId(member.getId());
        List<OrderResponse> orderList = orderService.findOrderByMemberId(member.getId());

        model.addAttribute("reviewList", reviewList);
        model.addAttribute("orderList", orderList);
        return "mypage.tiles";
    }

    @MemberOnly
    @PostMapping("/me.do")
    public String updateNickname(@RequestBody NicknameRequest nickname,
            HttpServletRequest request) {
        final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");

        final Member updatedMember = new Member(member, nickname.getNickname());
        memberService.updateMemberById(updatedMember);

        request.getSession().setAttribute("member", updatedMember);
        return "redirect:/me.do";
    }
}
