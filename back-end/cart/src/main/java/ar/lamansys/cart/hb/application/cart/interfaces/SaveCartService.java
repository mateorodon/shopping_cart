package ar.lamansys.cart.hb.application.cart.interfaces;

import ar.lamansys.cart.hb.application.cart.exceptions.NotUniqueCartException;
import ar.lamansys.cart.hc.domain.cart.CartBO;

public interface SaveCartService {

    CartBO run(CartBO cart) throws NotUniqueCartException;
}
