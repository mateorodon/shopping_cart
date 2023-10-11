package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.interfaces.FindCartProductsService;
import ar.lamansys.cart.hb.application.cart.interfaces.GetCartProductsService;
import ar.lamansys.cart.hb.application.cart.port.CartPort;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindCartProductsServiceImpl implements FindCartProductsService {
    CartPort cartPort;
    GetCartProductsService getCartProductsService;

    @Override
    public CartBO run(Integer cart_id, Integer user_id) throws CartDoesNotExistException {
        CartBO out = cartPort.findById(cart_id,user_id).orElseThrow(() -> new CartDoesNotExistException(cart_id));
        out.setProducts(getCartProductsService.run(cart_id,user_id));
        return out;
    }
}
