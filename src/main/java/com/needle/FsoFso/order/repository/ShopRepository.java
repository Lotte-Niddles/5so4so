package com.needle.FsoFso.order.repository;

import com.needle.FsoFso.order.dto.Shop.DisplayShopDto;
import com.needle.FsoFso.order.dto.Shop.ShopDto;
import com.needle.FsoFso.order.repository.mybatis.ShopMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShopRepository {
    private final ShopMapper shopMapper;

    public ShopRepository(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    public List<ShopDto> findItems(Long userId, List<Long> productsId) {
        List<ShopDto> retShopDto = new ArrayList<>();
        for (Long id : productsId) {
            retShopDto.add(shopMapper.findUserChoiceProductId(userId, id));
        }
//        retShopDto.stream().map(shopDto -> shopMapper.findUserChoiceProductId(userId, shopDto.getId()));
        return retShopDto;
    }

    public List<Long> findUserProductIdList(Long userId) {
        return shopMapper.findUserProductIdList(userId);
    }

    public List<DisplayShopDto> findAllDisplayDto(Long userId){
        return shopMapper.findAllDisplayDto(userId);
    }
}
