package ar.lamansys.cart.hb.application.cart_product.interfaces;

import ar.lamansys.cart.hb.application.cart_product.exceptions.CartProductDoesNotExistException;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;

public interface FindCartProductService {

    CartProductBO run(Integer product_id, Integer cart_id, Integer user_id) throws CartProductDoesNotExistException;
}
