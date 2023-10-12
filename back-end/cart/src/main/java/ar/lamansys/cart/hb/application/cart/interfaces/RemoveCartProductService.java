package ar.lamansys.cart.hb.application.cart.interfaces;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart_product.exceptions.CartProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.user.exceptions.UserDoesNotExistException;

public interface RemoveCartProductService {

    void run(Integer user_id,Integer product_id) throws UserDoesNotExistException, ProductDoesNotExistException, CartDoesNotExistException, CartProductDoesNotExistException;
}
