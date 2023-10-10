package ar.lamansys.cart.hb.application.product.implementation;

import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.interfaces.FindProductService;
import ar.lamansys.cart.hb.application.product.port.ProductPort;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FindProductServiceImpl implements FindProductService {

    private ProductPort productPort;

    @Override
    public ProductBO run(Integer id) throws ProductDoesNotExistException {
        return productPort.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistException(id));
    }
}
