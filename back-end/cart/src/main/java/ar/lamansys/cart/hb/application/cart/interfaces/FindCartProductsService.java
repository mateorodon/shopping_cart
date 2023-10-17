package ar.lamansys.cart.hb.application.cart.interfaces;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hc.domain.cart.CartBO;

public interface FindCartProductsService {


    CartBO run(Integer user_id) throws CartDoesNotExistException;
}
