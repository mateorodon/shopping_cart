package ar.lamansys.cart.hb.application.product.implementation;

import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hb.application.product.interfaces.CheckStockService;
import ar.lamansys.cart.hb.application.product.port.ProductPort;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckStockServiceImpl implements CheckStockService {

    private ProductPort productPort;
    @Override
    public boolean run(Integer amount, ProductBO product) throws StockNotAvailableException {
        if (amount <= product.getStock()){
            return true;
        }
        else{
            throw new StockNotAvailableException(product.getStock());
        }
    }
}
