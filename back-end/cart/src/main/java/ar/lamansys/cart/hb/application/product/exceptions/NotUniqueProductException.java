package ar.lamansys.cart.hb.application.product.exceptions;


import ar.lamansys.cart.hc.domain.product.ProductBO;

public class NotUniqueProductException extends Exception{

    public NotUniqueProductException(ProductBO product){
        super("Ya existe un producto con el codigo " + product.getProduct_id());
    }
}
