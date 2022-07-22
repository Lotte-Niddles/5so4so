package com.needle.FsoFso.order.repository.mybatis;

import com.needle.FsoFso.order.dto.Shop.DisplayShopDto;
import com.needle.FsoFso.order.dto.Shop.ShopDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopMapper {

    ShopDto findUserChoiceProductId(@Param("shopUserId") Long shopUserId, @Param("productsId") Long productsId);

    List<Long> findUserProductIdList(Long userId);

    List<DisplayShopDto> findAllDisplayDto(Long userId);

    void changeUserProductCnt(@Param("changeItemCnt") Long changeItemCnt, @Param("productId") Long productId, @Param("userId") Long userId);

//    @Delete("delete from cart where product_id = #{productId} and member_id = #{memberId}")
    void deleteCartProduct(@Param("productId") Long productId, @Param("userId") Long userId);
}
