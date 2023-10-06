package ar.lamansys.cart.hb.application.product.exceptions;

public class ProductDoesNotExistException extends Exception{

    public ProductDoesNotExistException(Integer id){
        super("No existe el producto con el id: " + id);
    }
}
