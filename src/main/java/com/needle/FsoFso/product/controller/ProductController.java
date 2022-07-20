package com.needle.FsoFso.product.controller;

import com.needle.FsoFso.product.dto.ProductDto;
import com.needle.FsoFso.product.service.ProductService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

	@GetMapping("productList.do")
	public String productList(Integer pageNumber, Model model) {
		logger.info("ProductController productList()" + new Date());

		int pageStartItemNumber = 1;
		if (pageNumber != null) {
			pageStartItemNumber = 1 + 12 * pageNumber;
		}
		
		List<ProductDto> productList = productService.getproducPagelist(pageStartItemNumber);
		int allProductCount = productService.getAllProductCount();
		
		model.addAttribute("productList", productList);
		model.addAttribute("allProductCount", allProductCount);
		model.addAttribute("pageNumber", pageNumber);
		return "productList.tiles"; 
	}
	
	// TODO : 지훈 detail test
	@GetMapping("productDetail.do")
	public String productDetail(Model model, HttpServletRequest req) {
		logger.info("ProductController productDetail()" + new Date());

		String sid = req.getParameter("id");
		
		if (sid.equals("") || sid == null) {
			return "productList.tiles";
		}
		int id = Integer.parseInt(sid);
		model.addAttribute("id", id);
		return "productDetail.tiles";
	}
}
