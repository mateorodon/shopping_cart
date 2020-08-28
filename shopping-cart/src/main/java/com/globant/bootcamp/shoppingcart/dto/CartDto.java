package com.globant.bootcamp.shoppingcart.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CartDto {
	private Long id;
	private String user;
	private List<ProductDto> products;

	public Double getTotal() {
		Double total = 0D;
		if (products == null) {
			return total;
		}

		for (ProductDto p : products) {
			total += p.getPrice();
		}
		return total;
	}

}
