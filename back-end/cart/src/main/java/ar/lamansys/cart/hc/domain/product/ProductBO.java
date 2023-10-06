package ar.lamansys.cart.hc.domain.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductBO {
    private Integer product_id;
    private String name;
    private Integer stock;
    private BigDecimal price;
}
