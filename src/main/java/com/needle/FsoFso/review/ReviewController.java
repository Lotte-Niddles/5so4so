package com.needle.FsoFso.review;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.product.services.ProductService;

@Controller
public class ReviewController {

	private final ProductService productService;

	public ReviewController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/addReview.do")
	public String addReviewPage(Model model, @RequestParam(value = "id", required = true) int productId) {

		ProductDto product = productService.getProductById(productId);
		
		model.addAttribute("product", product);
		
		return "addReview.tiles";
	}

}
