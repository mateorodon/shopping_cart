package ar.lamansys.cart.hb.application.cart.exceptions;


public class CartDoesNotExistException extends Exception{

    public CartDoesNotExistException(Integer id){
        super("No existe ningun carrito con el id " + id);
    }
}
