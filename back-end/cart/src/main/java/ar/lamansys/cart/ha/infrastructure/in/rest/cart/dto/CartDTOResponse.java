package ar.lamansys.cart.ha.infrastructure.in.rest.cart.dto;

import ar.lamansys.cart.ha.infrastructure.in.rest.cart_product.CartProductDTOResponse;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTOResponse {

    private Integer cart_id;
    private Integer user_id;
    private List<CartProductDTOResponse> products;
}
