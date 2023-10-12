package ar.lamansys.cart.hb.application.cart.exceptions;


public class CartDoesNotExistException extends Exception{

    public CartDoesNotExistException(Integer id){
        super("El usuario con id " + id + " no cuenta con un carrito actualmente");
    }
}
