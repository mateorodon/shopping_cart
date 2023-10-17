package ar.lamansys.cart.hb.application.product.implementation;

import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hb.application.product.interfaces.UpdateStockService;
import ar.lamansys.cart.hb.application.product.port.ProductPort;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateStockServiceImpl implements UpdateStockService {

    ProductPort productPort;
    @Override
    public void run(ProductBO product,Integer amount) throws ProductDoesNotExistException, StockNotAvailableException {
        ProductBO p = productPort.findById(product.getProduct_id()).orElseThrow(() -> new ProductDoesNotExistException(product.getProduct_id()));
        Integer newStock = p.getStock() - amount;
        if (newStock <0)
            throw new StockNotAvailableException(p.getStock());
        p.setStock(newStock);
        productPort.save(p);
    }
}
