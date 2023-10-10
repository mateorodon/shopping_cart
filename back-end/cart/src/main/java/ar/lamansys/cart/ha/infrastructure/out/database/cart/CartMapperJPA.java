package ar.lamansys.cart.ha.infrastructure.out.database.cart;

import ar.lamansys.cart.hc.domain.cart.CartBO;

public class CartMapperJPA {
    public static CartBO toCartBO(CartEntity cart){
        return new CartBO(cart.getCartID().getCart_id(),cart.getCartID().getUser_id());
    }
    public static CartEntity toCartEntity(CartBO cart){
        CartID cartId = new CartID(cart.getCart_id(), cart.getUser_id());
        return new CartEntity(cartId);
    }
}
