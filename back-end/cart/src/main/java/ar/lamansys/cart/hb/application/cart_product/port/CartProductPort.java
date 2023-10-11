package ar.lamansys.cart.hb.application.cart_product.port;

import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;

import java.util.List;

public interface CartProductPort {

    CartProductBO save(CartProductBO cartProduct);
    List<CartProductBO> getCartProducts(Integer cart_id, Integer user_id);

}
