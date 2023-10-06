package ar.lamansys.cart.hb.application.product.interfaces;

import ar.lamansys.cart.hb.application.product.exceptions.NotUniqueProductException;
import ar.lamansys.cart.hc.domain.product.ProductBO;

public interface SaveProductService {

    ProductBO run(ProductBO product) throws NotUniqueProductException;
}
