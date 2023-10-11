package ar.lamansys.cart.ha.infrastructure.in.rest.cart_product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartProductDTOResponse {

    private Integer product_id;
    private Integer amount;

}
