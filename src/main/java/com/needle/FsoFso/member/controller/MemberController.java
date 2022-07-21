package com.needle.FsoFso.member.controller;

import com.needle.FsoFso.member.kakao.dto.KakaoOauthInfo;
import com.needle.FsoFso.member.service.Member;
import com.needle.FsoFso.member.service.MemberService;
import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.review.dto.ReviewDto;
import java.util.ArrayList;
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

	@PostMapping("/updateNickname.do")
	public String updateNickname(HttpServletRequest request) {
		// TODO return url 변경, memberId 변경

//		if (!AttributeContainer.hasSessionAttributeOf(request, "member")) {
//			return "";
//		}
//
//		long memberId = ((Member) AttributeContainer.sessionAttributeFrom(request, "member")).getId();
		long memberId = 12;
		String nickname = request.getParameter("nickname");
		System.out.println(nickname);

		Member member = new Member(memberId, 0L, nickname, "", "", null, null);

		memberService.updateMemberById(member);

		return "";
	}

	@GetMapping("/reviewList.do")
	public String getReviewList(Model model) {
		// TODO return url 변경, memberId 변경

//		if (!AttributeContainer.hasSessionAttributeOf(request, "member")) {
//			return "";
//		}
//
//		long memberId = ((Member) AttributeContainer.sessionAttributeFrom(request, "member")).getId();
		long memberId = 12;

		List<ReviewDto> reviewList = reviewService.findReviewsByMemberId(memberId);
		List<ProductDto> productList = new ArrayList<ProductDto>();

		for(ReviewDto review : reviewList) {
			productList.add(productService.getProductById(review.getProductId()));
		}

		model.addAttribute("reviewList", reviewList);
		model.addAttribute("productList", productList);

		return "";
	}

}
