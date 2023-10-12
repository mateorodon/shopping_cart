package ar.lamansys.cart.hb.application.cart_product.port;

import ar.lamansys.cart.ha.infrastructure.out.database.cart_product.CartProductID;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;

import java.util.List;
import java.util.Optional;

public interface CartProductPort {

    CartProductBO save(CartProductBO cartProduct);
    List<CartProductBO> getCartProducts(Integer cart_id, Integer user_id);

    void delete(CartProductBO cartProduct);

    public Optional<CartProductBO> findById(Integer product_id, Integer cart_id, Integer user_id);

}
