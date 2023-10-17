package ar.lamansys.cart.hb.application.cart.interfaces;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;

public interface FinishBuyService {

    void run(Integer user_id) throws CartDoesNotExistException, ProductDoesNotExistException, StockNotAvailableException;
}
