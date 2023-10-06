package ar.lamansys.cart.hb.application.product.implementation;

import ar.lamansys.cart.hb.application.product.interfaces.DeleteProductService;
import ar.lamansys.cart.hb.application.product.port.ProductPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProductServiceImpl implements DeleteProductService {

    private ProductPort productPort;
    @Override
    public void run(Integer id) {
        productPort.delete(id);
    }
}
