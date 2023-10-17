package ar.lamansys.cart.hb.application.product.port;

import ar.lamansys.cart.hc.domain.product.ProductBO;

import java.util.Optional;

public interface ProductPort {

    ProductBO save(ProductBO product);
    Optional<ProductBO> findById(Integer id);
    boolean exists(Integer id);

    void delete(Integer id);

    void updateStock(Integer id,Integer amount);
}
