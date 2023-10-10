package ar.lamansys.cart.hb.application.cart.exceptions;

public class NotUniqueCartException extends Exception{

    public NotUniqueCartException(Integer user){
        super("El usuario con id " + user + " ya cuenta con un carrito.");
    }
}
