package ar.lamansys.cart.ha.infrastructure.out.database.product;

import ar.lamansys.cart.hb.application.product.port.ProductPort;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
@Primary
public class ProductPortImpl implements ProductPort {

    ProductRepository productRepository;
    @Override
    public ProductBO save(ProductBO product) {
        return ProductMapperJPA.toProductBO(productRepository.save(ProductMapperJPA.toProductEntity(product)));
    }

    @Override
    public Optional<ProductBO> findById(Integer id) {
        return productRepository.findById(id).map(ProductMapperJPA::toProductBO);
    }

    @Override
    public boolean exists(Integer id) {
        return productRepository.existsById(id);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateStock(Integer id,Integer amount) {
        productRepository.updateStock(id,amount);
    }
}
