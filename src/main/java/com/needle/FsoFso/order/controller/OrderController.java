package com.needle.FsoFso.order.controller;

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
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final ShopService shopService;

    public OrderController(OrderService orderService, ShopService shopService) {
        this.orderService = orderService;
        this.shopService = shopService;
    }

    @GetMapping("order.do")
    public String orderPage(Model model, HttpServletRequest request) {
        Optional<Long> userIdInfo = getUserId(request);
        if(userIdInfo == null){
            return "productList.tiles";
        }
        Long userId = userIdInfo.get();
        System.out.println("userId = " + userId);
        List<DisplayShopDto> allDisplayDto = shopService.findAllDisplayDto(userId);

        Long allPrice = shopService.getAllPrice(allDisplayDto);

        for (DisplayShopDto displayShopDto : allDisplayDto) {
            System.out.println("displayShopDto = " + displayShopDto);
        }
        model.addAttribute("stockFlag", 0);
        model.addAttribute("allDisplayDto", allDisplayDto);
        model.addAttribute("allPrice", allPrice);
        return "order.tiles";
    }

    /**
     * 상품 결제 버튼 로직
     */
    @Transactional
    @PostMapping("orderProduct.do")
    public String orderProduct(@RequestBody Map<String, List<Long>> productId, Model model, HttpServletRequest request) {
        Long userId = getUserId(request).get();
        List<Long> productsId = productId.get("id");
        List<ShopDto> products = shopService.findShopInfo(userId, productsId);

        Long orderId = orderService.saveOrder(products, userId);
        orderService.saveOrderProduct(products, userId, orderId);

        List<OrderSuccessDto> orderSuccessDtoList = products.stream().map(shopDto -> (new OrderSuccessDto(shopDto.getQuantity(), shopDto.getName(), shopDto.getPrice()))).collect(Collectors.toList());
        model.addAttribute("orderSuccessDtoList", orderSuccessDtoList);
        return "orderSuccess.tiles";
    }

    /**
     * 장바구니 수량 변경 작업중
     */
    @PostMapping("cartNumReplace.do")
    public String cartNumReplace(HttpServletRequest request, Long changeItemCnt, Long productId, Model model) {
        Long userId = getUserId(request).get();
//        Long userId = 12L;
        System.out.println("userId = " + userId + " changeItemCnt : " + changeItemCnt + " productId : " + productId);

        Integer stockFlag = shopService.changeUserProductCnt(changeItemCnt, productId, userId);
        List<DisplayShopDto> allDisplayDto = shopService.findAllDisplayDto(userId);
        Long allPrice = shopService.getAllPrice(allDisplayDto);

        if(stockFlag == 1){
            model.addAttribute("stockFlag", 1);
        }else{
            model.addAttribute("stockFlag", 2);
        }
        model.addAttribute("allDisplayDto", allDisplayDto);
        model.addAttribute("allPrice", allPrice);
        System.out.println("model = " + model);
        return "order.tiles";
    }

    private Optional<Long> getUserId(HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute("member");
        Optional<Long> id = Optional.ofNullable(member.getId());
        return id;
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