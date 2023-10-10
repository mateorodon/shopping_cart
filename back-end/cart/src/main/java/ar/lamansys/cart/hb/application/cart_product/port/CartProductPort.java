package ar.lamansys.cart.hb.application.cart_product.port;

import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;

public interface CartProductPort {

    CartProductBO save(CartProductBO cartProduct);
}
