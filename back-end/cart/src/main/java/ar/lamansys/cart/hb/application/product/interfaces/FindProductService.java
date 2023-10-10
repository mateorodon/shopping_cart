package ar.lamansys.cart.hb.application.product.interfaces;

import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hc.domain.product.ProductBO;


public interface FindProductService {

    ProductBO run(Integer id) throws ProductDoesNotExistException;
}
