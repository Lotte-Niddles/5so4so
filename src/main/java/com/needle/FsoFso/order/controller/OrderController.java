package com.needle.FsoFso.order.controller;

import com.needle.FsoFso.common.aop.MemberOnly;
import com.needle.FsoFso.common.util.AttributeContainer;
import com.needle.FsoFso.member.service.Member;
import com.needle.FsoFso.order.domain.Order;
import com.needle.FsoFso.order.dto.Order.OrderSearchCond;
import com.needle.FsoFso.order.dto.Order.OrderSuccessDto;
import com.needle.FsoFso.order.dto.Shop.DisplayShopDto;
import com.needle.FsoFso.order.dto.Shop.ShopDto;
import com.needle.FsoFso.order.service.OrderService;
import com.needle.FsoFso.order.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final ShopService shopService;

    public OrderController(OrderService orderService, ShopService shopService) {
        this.orderService = orderService;
        this.shopService = shopService;
    }

    @MemberOnly
    @GetMapping("order.do")
    public String orderPage(Model model, HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute("member");
        viewRander(model, member.getId());
        return "order.tiles";
    }

    @MemberOnly
    @Transactional
    @PostMapping("orderProduct.do")
    public String orderProduct(@RequestBody Map<String, List<Long>> productId, Model model,
            HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute("member");
        Long userId = member.getId();

        List<Long> productsId = productId.get("productId");
        List<ShopDto> products = shopService.findShopInfo(userId, productsId);
        Long orderId = orderService.saveOrder(products, userId);
        orderService.saveOrderProduct(products, userId, orderId, productsId);
        List<OrderSuccessDto> orderSuccessDtoList = products.stream()
                .map(shopDto -> (
                        new OrderSuccessDto(
                                shopDto.getQuantity(),
                                shopDto.getName(),
                                shopDto.getPrice(),
                                shopDto.getImgSrc())
                ))
                .collect(Collectors.toList());
        model.addAttribute("orderSuccessDtoList", orderSuccessDtoList);
        return "orderSuccess.tiles";
    }


    @MemberOnly
    @GetMapping("cartNumReplace.do")
    public String cartNumReplace(Long changeItemCnt, Long productId, Model model,
            HttpServletRequest request) {
        final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");
        Integer stockFlag = shopService.changeUserProductCnt(changeItemCnt, productId,
                member.getId());
        List<DisplayShopDto> allDisplayDto = shopService.findAllDisplayDto(member.getId());
        Long allPrice = shopService.getAllPrice(allDisplayDto);

        if (stockFlag == 1) {
            model.addAttribute("stockFlag", 1);
        } else {
            model.addAttribute("stockFlag", 2);
        }
        model.addAttribute("allDisplayDto", allDisplayDto);
        model.addAttribute("allPrice", allPrice);
        return "order.tiles";
    }

    @MemberOnly
    @PostMapping("cartDeleteProduct.do")
    public String cartDeleteProduct(@RequestBody Map<String, List<Long>> productId,
            HttpServletRequest request, Model model) {
        final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");
        List<Long> idList = productId.get("productId");
        shopService.deleteCartProduct(idList,member.getId());
        viewRander(model, member.getId());
        return "redirect:/order.do";
    }

    private void viewRander(Model model, Long userId) {
        List<DisplayShopDto> allDisplayDto = shopService.findAllDisplayDto(userId);

        Long allPrice = shopService.getAllPrice(allDisplayDto);

        model.addAttribute("stockFlag", 0);
        model.addAttribute("allDisplayDto", allDisplayDto);
        model.addAttribute("allPrice", allPrice);
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