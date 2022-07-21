package com.needle.FsoFso.order.controller;

import com.needle.FsoFso.order.domain.Order;
import com.needle.FsoFso.order.dto.Order.OrderSearchCond;
import com.needle.FsoFso.order.dto.Shop.DisplayShopDto;
import com.needle.FsoFso.order.dto.Shop.ShopDto;
import com.needle.FsoFso.order.service.OrderService;
import com.needle.FsoFso.order.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final ShopService shopService;

    public OrderController(OrderService orderService, ShopService shopService) {
        this.orderService = orderService;
        this.shopService = shopService;
    }

    @GetMapping("order.do")
    public String orderPage(Model model){
        Long userId = 2L;
        List<DisplayShopDto> allDisplayDto = shopService.findAllDisplayDto(userId);
        Long allPrice = shopService.getAllPrice(allDisplayDto);
        model.addAttribute("allDisplayDto", allDisplayDto);
        model.addAttribute("allPrice", allPrice);
        return "order.tiles";
    }

    /**
     * 상품 결제 버튼 로직
     */
    @Transactional
    @PostMapping("orderProduct.do")
    public void orderProduct(@RequestBody Map<String, List<Long>> productId){
//        Long userId = SeesionId.get()
        Long userId = 2L;
        List<Long> productsId = productId.get("id");

        List<ShopDto> products = shopService.findShopInfo(userId, productsId);
        Long orderId = orderService.saveOrder(products, userId);

        orderService.saveOrderProduct(products, userId, orderId);
    }

    /**
     * 적용 전, 동적 쿼리 필요시 사용
     */
    @GetMapping("orderFindId.do")
    public void orderFindOrder(Long id) {
        System.out.println("Long = " + id);
        orderService.findOrder(id);
        System.out.println("out signal");
    }

    /**
     * 적용 전, 동적 쿼리 필요시 사용
     */
    @GetMapping("orderCmpPriceFind.do")
    public void orderCmpPriceFind(@ModelAttribute OrderSearchCond orderSearchCond) {
        System.out.println("OrderSearchCond = " + orderSearchCond);
        List<Order> orderCmpPriceFind = orderService.findOrderCmpPriceFind(orderSearchCond);
        for (Order order : orderCmpPriceFind) {
            System.out.println(order);
        }
        System.out.println("out signal");
    }
}