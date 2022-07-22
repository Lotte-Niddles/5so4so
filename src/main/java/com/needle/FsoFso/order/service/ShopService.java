package com.needle.FsoFso.order.service;

import com.needle.FsoFso.order.dto.Shop.DisplayShopDto;
import com.needle.FsoFso.order.dto.Shop.ShopDto;
import com.needle.FsoFso.order.repository.ShopRepository;
import com.needle.FsoFso.order.repository.mybatis.ProductsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {
    private final ProductsMapper productsMapper;
    private final ShopRepository shopRepository;

    public ShopService(ProductsMapper productsMapper, ShopRepository shopRepository) {
        this.productsMapper = productsMapper;
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

    public Integer changeUserProductCnt(Long changeItemCnt, Long productId, Long userId){
        Long curStock = productsMapper.findStock(productId);
        if(curStock > changeItemCnt) {
            shopRepository.changeUserProductCnt(changeItemCnt, productId, userId);
            return 1;
        }
        return 2;
    }

    public void deleteCartProduct(List<Long> idList, Long userId){
        for (Long productId : idList) {
            shopRepository.deleteCartProduct(productId, userId);
        }
    }
}