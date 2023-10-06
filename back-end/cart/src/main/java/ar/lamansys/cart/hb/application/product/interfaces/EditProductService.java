package ar.lamansys.cart.hb.application.product.interfaces;

import ar.lamansys.cart.hb.application.product.exceptions.NotUniqueProductException;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hc.domain.product.ProductBO;

public interface EditProductService {

    ProductBO run(Integer id, ProductBO newProduct) throws ProductDoesNotExistException, NotUniqueProductException;
}
