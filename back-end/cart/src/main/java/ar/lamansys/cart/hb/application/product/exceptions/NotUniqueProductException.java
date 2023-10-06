package ar.lamansys.cart.hb.application.product.exceptions;


public class NotUniqueProductException extends Exception{

    public NotUniqueProductException(String name){
        super("Ya existe el siguiente producto: " + name);
    }
}
