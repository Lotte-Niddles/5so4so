package com.needle.FsoFso.order.service;

import com.needle.FsoFso.order.dto.Shop.DisplayShopDto;
import com.needle.FsoFso.order.dto.Shop.ShopDto;
import com.needle.FsoFso.order.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Long getAllPrice(List<DisplayShopDto> DisplayList){
        return DisplayList.stream().map(displayShopDto -> displayShopDto.getPrice()).collect(Collectors.toList()).stream().mapToLong(Long::longValue).sum();
    }

    public List<ShopDto> findShopInfo(Long userId, List<Long> productsId) {
        return shopRepository.findItems(userId, productsId);
    }

    public List<Long> findUserProductIdList(Long userId) {
        return shopRepository.findUserProductIdList(userId);
    }

    public List<DisplayShopDto> findAllDisplayDto(Long userId){
        return shopRepository.findAllDisplayDto(userId);
    }
}