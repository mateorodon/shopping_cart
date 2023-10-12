package ar.lamansys.cart.hb.application.cart_product.interfaces;

import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;

public interface DeleteCartProductService {

    void run(CartProductBO cartProduct);
}
