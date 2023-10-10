package ar.lamansys.cart.hb.application.user.exceptions;

public class UserDoesNotExistException extends Exception{

    public UserDoesNotExistException(Integer id){
        super("No existe ningun usuario con id " + id);
    }
}
