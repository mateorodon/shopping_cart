package com.globant.bootcamp.shoppingcart.dto;

import com.globant.bootcamp.shoppingcart.model.Cart;
import com.globant.bootcamp.shoppingcart.model.Product;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface Mapper {

	Mapper INSTANCE = Mappers.getMapper(Mapper.class);

	CartDto convert(Cart cart);

	Cart convert(CartDto cartDto);

	ProductDto convert(Product product);

	Product convert(ProductDto productDto);

}
