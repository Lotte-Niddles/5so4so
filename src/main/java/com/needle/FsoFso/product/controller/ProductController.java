package com.needle.FsoFso.product.controller;

import com.needle.FsoFso.product.dto.CartDto;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        int totalCount = productService.getAllProductCount();

        model.addAttribute("productList", productList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pageNumber", pageNumber);
        return "productList.tiles";
    }

    // TODO : 지훈 detail test
    @GetMapping("productDetail.do")
    public String productDetail(Model model, HttpServletRequest req,
            @RequestParam(value = "id", required = true) int productId) {

        ProductDto product = productService.getProductById(productId);
        model.addAttribute("product", product);

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
        model.addAttribute("product", product);

        return "productDetail.tiles";
    }
}
