package ar.lamansys.cart.hb.application.cart_product.implementation;

import ar.lamansys.cart.hb.application.cart_product.exceptions.CartProductDoesNotExistException;
import ar.lamansys.cart.hb.application.cart_product.interfaces.FindCartProductService;
import ar.lamansys.cart.hb.application.cart_product.port.CartProductPort;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindCartProductServiceImpl implements FindCartProductService {

    private CartProductPort cartProductPort;

    @Override
    public CartProductBO run(Integer product_id, Integer cart_id, Integer user_id) throws CartProductDoesNotExistException {
        return cartProductPort.findById(product_id,cart_id,user_id).orElseThrow(() -> new CartProductDoesNotExistException(user_id,product_id));
    }
}
