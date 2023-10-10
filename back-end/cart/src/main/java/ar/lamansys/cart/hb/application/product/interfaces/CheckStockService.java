package ar.lamansys.cart.hb.application.product.interfaces;

import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hc.domain.product.ProductBO;

public interface CheckStockService {

    boolean run(Integer amount, ProductBO product) throws StockNotAvailableException;
}
