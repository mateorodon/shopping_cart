package ar.lamansys.cart.hb.application.user.exceptions;

public class NotUniqueUserException extends Exception{

    public NotUniqueUserException(String username){
        super("Ya existe el usuario " + username);
    }
}
