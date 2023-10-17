package ar.lamansys.cart.ha.infrastructure.out.database.cart;

import ar.lamansys.cart.hc.domain.cart.CartBO;

public class CartMapperJPA {
    public static CartBO toCartBO(CartEntity cart){
        return new CartBO(cart.getCart_id(),cart.getUser_id(),cart.isFinalized());
    }
    public static CartEntity toCartEntity(CartBO cart){
        return new CartEntity(cart.getCart_id(),cart.getUser_id(),cart.isFinalized());
    }
}
