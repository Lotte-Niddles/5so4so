package com.needle.FsoFso.review.controller;

import com.needle.FsoFso.common.aop.MemberOnly;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.needle.FsoFso.common.util.AttributeContainer;
import com.needle.FsoFso.member.service.Member;
import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.product.service.ProductService;
import com.needle.FsoFso.review.dto.MemberProductDto;
import com.needle.FsoFso.review.dto.Review;
import com.needle.FsoFso.review.service.ReviewService;

@Controller
public class ReviewController {

	private final ProductService productService;
	private final ReviewService reviewService;

	public ReviewController(ProductService productService, ReviewService reviewService) {
		this.productService = productService;
		this.reviewService = reviewService;
	}

	@GetMapping("/addReview.do")
	public String addReviewPage(Model model, @RequestParam(value = "id", required = true) int productId) {

		ProductDto product = productService.getProductById(productId);
		
		model.addAttribute("product", product);
		
		return "addReview.tiles";
	}

	@MemberOnly
	@PostMapping("/addReview.do")
	public String addReview(Model model, HttpServletRequest req) {
		if (!AttributeContainer.hasSessionAttributeOf(req, "member")) {
			return "redirect:/login.do";
		}
		final Member member = (Member) AttributeContainer.sessionAttributeFrom(req, "member");

		long productId = Long.parseLong(req.getParameter("productId"));
		String content = req.getParameter("content");
		
		Review review = new Review(0L, member.getId(), productId, content, null, null);
		
		reviewService.save(review);
		
		
		return "redirect:/productDetail.do?id="+productId;
	}

	@MemberOnly
	@GetMapping("/checkBuyMember.do")
	@ResponseBody
	public String isBuyMemeber(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		String answer = "true";

		if (!AttributeContainer.hasSessionAttributeOf(req, "member")) {
			return "redirect:/login.do";
		}
		final Member member = (Member) AttributeContainer.sessionAttributeFrom(req, "member");

		
		long productId = Long.parseLong((String) map.get("productId"));
		
		int buyCount = reviewService.getCountByUserIdProductId(new MemberProductDto(member.getId(),productId));
		
		if(0 == buyCount) {
			answer = "false";
		}
		
		return answer;
	}

}
