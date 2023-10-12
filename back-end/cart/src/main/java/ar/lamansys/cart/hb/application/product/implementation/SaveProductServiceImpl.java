package ar.lamansys.cart.hb.application.product.implementation;

import ar.lamansys.cart.hb.application.product.exceptions.NotUniqueProductException;
import ar.lamansys.cart.hb.application.product.interfaces.SaveProductService;
import ar.lamansys.cart.hb.application.product.port.ProductPort;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveProductServiceImpl implements SaveProductService {

    private ProductPort productPort;
    @Override
    public ProductBO run(ProductBO product) throws NotUniqueProductException {
        if (productPort.exists(product.getProduct_id())){
            throw new NotUniqueProductException(product);
        }
        return productPort.save(product);
    }
}
