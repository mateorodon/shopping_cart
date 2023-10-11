package ar.lamansys.cart.hb.application.cart.interfaces;

import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;

import java.util.List;

public interface GetCartProductsService {

    List<CartProductBO> run(Integer cart_id,Integer user_id);
}
