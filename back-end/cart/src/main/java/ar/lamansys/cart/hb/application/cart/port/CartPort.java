package ar.lamansys.cart.hb.application.cart.port;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hc.domain.cart.CartBO;

import java.util.Optional;

public interface CartPort {

    CartBO save(CartBO cart);

    boolean exists(Integer cart_id,Integer user_id);

    Optional<CartBO> findById(Integer cart_id,Integer user_id);

    CartBO findByUser_id(Integer user_id);

}
