package ar.lamansys.cart.hb.application.product.interfaces;

import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hc.domain.product.ProductBO;

public interface UpdateStockService {

    void run(ProductBO product,Integer amount) throws ProductDoesNotExistException, StockNotAvailableException;
}
