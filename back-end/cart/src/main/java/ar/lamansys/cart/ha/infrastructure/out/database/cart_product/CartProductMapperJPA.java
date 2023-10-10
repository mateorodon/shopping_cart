package ar.lamansys.cart.ha.infrastructure.out.database.cart_product;

import ar.lamansys.cart.ha.infrastructure.out.database.cart.CartEntity;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;

public class CartProductMapperJPA {

    public static CartProductBO toCartProductBO(CartProductEntity cartProduct){
        CartProductID cartProductId = cartProduct.getCartProductID();
        return new CartProductBO(cartProductId.getProduct_id(),cartProductId.getCart_id(),cartProductId.getUser_id(),cartProduct.getAmount());
    }

    public static CartProductEntity toCartProductEntity(CartProductBO cartProduct){
        CartProductID cartProductId = new CartProductID(cartProduct.getProduct_id(), cartProduct.getCart_id(), cartProduct.getUser_id());
        return new CartProductEntity(cartProductId,cartProduct.getAmount());
    }
}
