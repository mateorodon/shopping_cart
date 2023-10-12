package ar.lamansys.cart.hb.application.cart.interfaces;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hc.domain.cart.CartBO;

import java.math.BigDecimal;

public interface GetMontoTotalService {

    BigDecimal run(Integer user_id) throws CartDoesNotExistException, ProductDoesNotExistException;

}
