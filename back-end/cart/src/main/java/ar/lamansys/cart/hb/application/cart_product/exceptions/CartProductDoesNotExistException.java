package ar.lamansys.cart.hb.application.cart_product.exceptions;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;

public class CartProductDoesNotExistException extends Exception{

    public CartProductDoesNotExistException(Integer user_id,Integer product_id){
        super("El usuario con id " + user_id + " no cuenta con el producto " + product_id + " en su carrito");
    }
}
