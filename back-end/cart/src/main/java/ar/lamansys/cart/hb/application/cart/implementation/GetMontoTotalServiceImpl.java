package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.interfaces.GetCartProductsService;
import ar.lamansys.cart.hb.application.cart.interfaces.GetMontoTotalService;
import ar.lamansys.cart.hb.application.cart.port.CartPort;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.interfaces.FindProductService;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class GetMontoTotalServiceImpl implements GetMontoTotalService {

    CartPort cartPort;
    FindProductService findProductService;
    GetCartProductsService getCartProductsService;
    @Override
    public BigDecimal run(Integer user_id) throws CartDoesNotExistException, ProductDoesNotExistException {
        CartBO cart = cartPort.findById(user_id,user_id).orElseThrow(() -> new CartDoesNotExistException(user_id));
        BigDecimal total = BigDecimal.valueOf(0.0);
        List<CartProductBO> products = getCartProductsService.run(user_id,user_id);
        for(CartProductBO cp : products){
            ProductBO product = findProductService.run(cp.getProduct_id());
            total = total.add(product.getPrice().multiply(BigDecimal.valueOf(cp.getAmount())));
        }
        return total;
    }
}
