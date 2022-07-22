package com.needle.FsoFso.order.service;

import com.needle.FsoFso.order.domain.Order;
import com.needle.FsoFso.order.dto.Order.OrderSearchCond;
import com.needle.FsoFso.order.dto.OrderProduct.OrderProduct;
import com.needle.FsoFso.order.dto.OrderResponse;
import com.needle.FsoFso.order.dto.Shop.ShopDto;
import com.needle.FsoFso.order.repository.OrderProductRepository;
import com.needle.FsoFso.order.repository.OrderRepository;
import com.needle.FsoFso.order.repository.ProductsRepository;
import com.needle.FsoFso.order.repository.ShopRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductsRepository productsRepository;
    private final ShopRepository shopRepository;

    public OrderService(
            OrderRepository orderRepository,
            OrderProductRepository orderProductRepository,
            ProductsRepository productsRepository,
            ShopRepository shopRepository
    ) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.productsRepository = productsRepository;
        this.shopRepository = shopRepository;
    }

    @Transactional
    public Long saveOrder(List<ShopDto> products, Long memberId) {
        Long totalPrice = products.stream()
                .mapToLong(ShopDto::getPrice)
                .sum();
        Order order = new Order(memberId, totalPrice);
        return orderRepository.save(order);
    }

    @Transactional
    public void saveOrderProduct(List<ShopDto> order, Long userId, Long orderId,
            List<Long> productsId) throws RuntimeException {
        for (ShopDto shopDto : order) {
            checkStockOf(shopDto.getProductId(), shopDto.getQuantity());

            orderProductRepository.save(
                    new OrderProduct(orderId, userId, shopDto.getProductId(), shopDto.getQuantity(),
                            shopDto.getPrice()));
            productsRepository.updateStockProducts(shopDto.getProductId(), shopDto.getQuantity());
        }
        for (Long productId : productsId) {
            shopRepository.deleteCartProduct(productId, userId);
        }
    }

    private void checkStockOf(Long productId, Long quantity) {
        Long stock = productsRepository.findStock(productId);

        if (stock < quantity) {
            throw new RuntimeException("재고 부족");
        }
    }

    public List<OrderResponse> findOrderByMemberId(Long id) {
        return orderRepository.findByMemberId(id);
    }

    /**
     * 적용 전, 동적 쿼리 필요시 사용
     */
    public Order findOrder(Long id) {
        System.out.println("[OrderService]id = " + id);
        Optional<Order> byId = orderRepository.findById(id);
        System.out.println(byId.get());
        System.out.println("[orderService find Value]" + byId.get());
        return byId.get();
    }

    /**
     * 적용 전, 동적 쿼리 필요시 사용
     */
    public List<Order> findOrderCmpPriceFind(OrderSearchCond orderSearchCond) {
        System.out.println("[OrederService]orderSearchCond = " + orderSearchCond);
        return orderRepository.findOrders(orderSearchCond);
    }
}