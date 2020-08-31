package com.globant.bootcamp.shoppingcart.dto;

import com.globant.bootcamp.shoppingcart.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartDto convert(Cart cart);

    Cart convert(CartDto cartDto);

}
