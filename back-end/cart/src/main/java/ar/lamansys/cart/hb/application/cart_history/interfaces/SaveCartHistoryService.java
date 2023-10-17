package ar.lamansys.cart.hb.application.cart_history.interfaces;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import ar.lamansys.cart.hc.domain.cart_history.CartHistoryBO;

public interface SaveCartHistoryService {

    CartHistoryBO run(CartBO cart) throws ProductDoesNotExistException, CartDoesNotExistException;
}
