package com.globant.bootcamp.shoppingcart.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductDto {
	private Long id;
	private String name;
	private Double price;
}
