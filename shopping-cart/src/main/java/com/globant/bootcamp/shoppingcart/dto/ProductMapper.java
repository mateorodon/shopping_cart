package com.globant.bootcamp.shoppingcart.dto;

import com.globant.bootcamp.shoppingcart.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto convert(Product product);

    Product convert(ProductDto productDto);

}
