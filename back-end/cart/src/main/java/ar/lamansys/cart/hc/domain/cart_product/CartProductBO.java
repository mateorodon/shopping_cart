package ar.lamansys.cart.hc.domain.cart_product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartProductBO {

    private Integer product_id;
    private Integer cart_id;
    private Integer user_id;
    private Integer amount;

    public CartProductBO(Integer product_id,Integer amount){
        this.product_id = product_id;
        this.amount = amount;
    }
}
