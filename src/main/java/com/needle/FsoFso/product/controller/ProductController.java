package com.needle.FsoFso.product.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import com.needle.FsoFso.product.dao.ProductDao;
import com.needle.FsoFso.product.dto.CartDto;
import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.product.services.ProductService;
import com.needle.FsoFso.review.dto.ReviewDto;
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
	public String productList(Integer pageNumber, Model model, HttpServletRequest req) {
		logger.info("ProductController productList()" + new Date());
		// TODO : 로그인 했다고 가졍하기위해서 session에 id set;
		String pageNumber1 = req.getParameter("pageNumber");
		req.getSession().setAttribute("loginId", "aaa");
		
		int start = 1;
		
		if(pageNumber != null) {
			start = 1 + 12 * pageNumber;
		}
		
		List<ProductDto> productList = productService.getproducPagelist(start);
		int len = productService.getAllProduct();
		
		model.addAttribute("productList", productList);
		model.addAttribute("len", len);
		model.addAttribute("pageNumber", pageNumber1);
		return "productList.tiles"; 
	}
	
	@GetMapping("productDetail.do")
	public String productDetail(Model model, HttpServletRequest req,
			@RequestParam(value = "id",required = true) int productId) {

		setProductDetailData(model, productId);
		
		return "productDetail.tiles";
	}
	
	@PostMapping("addCart.do")
	public String addCart(Model model, HttpServletRequest req) {
		int productId = Integer.parseInt(req.getParameter("productId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		ProductDto product = productService.getProductById(productId);
		// TODO : 세션에서 가져온 member 객체로 변경후 userService 제거
		int memberId = 12;
		
		CartDto cart = new CartDto(0, memberId, productId, quantity);
		productService.addCart(cart);
		model.addAttribute("product",product);
		
		return "redirect:/productDetail.do?id="+productId;
	}
	
	public void setProductDetailData(Model model, long productId) {
		ProductDto product = productService.getProductById(productId);
		List<ReviewDto> reviewList = reviewService.findReviewsByProductId(productId);
		List<String> nicknameList = new ArrayList<String>();
		
		for(ReviewDto review : reviewList) {
			Optional<Member> member = memberService.findById(review.getMemberId());
			nicknameList.add(member.orElse(new Member(0L, "", "", "")).getNickname());
		}
		
		model.addAttribute("product",product);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("nicknameList",nicknameList);
	}
	
}
