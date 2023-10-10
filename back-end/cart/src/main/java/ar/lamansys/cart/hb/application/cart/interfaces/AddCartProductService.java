package ar.lamansys.cart.hb.application.cart.interfaces;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hb.application.user.exceptions.UserDoesNotExistException;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import ar.lamansys.cart.hc.domain.product.ProductBO;

public interface AddCartProductService {

    CartProductBO run(Integer id_usuario, CartProductBO product)
            throws UserDoesNotExistException, ProductDoesNotExistException, StockNotAvailableException, CartDoesNotExistException;
}
