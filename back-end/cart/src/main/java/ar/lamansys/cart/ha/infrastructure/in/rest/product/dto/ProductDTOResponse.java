package ar.lamansys.cart.ha.infrastructure.in.rest.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOResponse {
    private Integer product_id;
    private String name;
    private Integer stock;
    private BigDecimal price;
}
