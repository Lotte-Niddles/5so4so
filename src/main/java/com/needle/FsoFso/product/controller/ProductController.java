package com.needle.FsoFso.product.controller;

import com.needle.FsoFso.common.aop.AdminOnly;
import com.needle.FsoFso.common.aop.MemberOnly;
import com.needle.FsoFso.common.util.AttributeContainer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.needle.FsoFso.product.dto.CartDto;
import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.product.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.needle.FsoFso.member.service.Member;
import com.needle.FsoFso.member.service.MemberService;
import com.needle.FsoFso.review.dto.Review;
import com.needle.FsoFso.review.service.ReviewService;

@Controller
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	private final ProductService productService;
	private final ReviewService reviewService;
	private final MemberService memberService;

	public ProductController(ProductService productService, ReviewService reviewService, MemberService memberService) {
		this.productService = productService;
		this.reviewService = reviewService;
		this.memberService = memberService;
	}

	@GetMapping("productList.do")
	public String productList(Integer pageNumber, Model model) {
		logger.info("ProductController productList()" + new Date());

		int pageStartItemNumber = 1;
		if (pageNumber != null) {
			pageStartItemNumber = 1 + 12 * pageNumber;
		}

		List<ProductDto> productList = productService.getproducPagelist(pageStartItemNumber);
		int totalCount = productService.getAllProductCount();

		model.addAttribute("productList", productList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageNumber", pageNumber);
		return "productList.tiles";
	}

	@GetMapping("productDetail.do")
	public String productDetail(Model model, HttpServletRequest req,
			@RequestParam(value = "id", required = true) int productId) {
		setProductDetailData(model, productId);

		return "productDetail.tiles";
	}

	@MemberOnly
	@PostMapping("addCart.do")
	public String addCart(Model model, HttpServletRequest req) {
		if (!AttributeContainer.hasSessionAttributeOf(req, "member")) {
			return "redirect:/login.do";
		}
		final Member member = (Member) AttributeContainer.sessionAttributeFrom(req, "member");
		
		int productId = Integer.parseInt(req.getParameter("productId"));
		ProductDto product = productService.getProductById(productId);
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		CartDto cart = new CartDto(0, member.getId(), productId, quantity);
		productService.addCart(cart);
		model.addAttribute("product", product);

		return "redirect:/productDetail.do?id=" + productId;
	}

	@MemberOnly
	public void setProductDetailData(Model model, long productId) {
		ProductDto product = productService.getProductById(productId);
		List<Review> reviewList = reviewService.findReviewsByProductId(productId);
		List<String> nicknameList = new ArrayList<String>();

		for (Review review : reviewList) {
			Optional<Member> member = memberService.findById(review.getMemberId());
			nicknameList.add(member.orElse(new Member(0L, "", "", "")).getNickname());
		}

		model.addAttribute("product", product);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("nicknameList", nicknameList);
	}

	@AdminOnly
	@GetMapping("delProduct.do")
	public String delProduct(HttpServletRequest request) {
		final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");

		long productId = Long.parseLong(request.getParameter("productId"));
		productService.removeProductById(productId);
		productService.removeCartByMemberIdProductId(new CartDto(0L, member.getId(), productId, 0));

		return "redirect:/adminProductList.do";
	}
}
