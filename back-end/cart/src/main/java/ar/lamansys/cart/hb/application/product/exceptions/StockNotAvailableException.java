package ar.lamansys.cart.hb.application.product.exceptions;

public class StockNotAvailableException extends Exception{

    public StockNotAvailableException(Integer stock){
        super("No hay suficiente stock de este producto. Actualmente hay " + stock + " unidades disponibles");
    }
}
