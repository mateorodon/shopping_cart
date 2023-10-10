package ar.lamansys.cart.hb.application.cart_product.implementation;

import ar.lamansys.cart.hb.application.cart_product.interfaces.SaveCartProductService;
import ar.lamansys.cart.hb.application.cart_product.port.CartProductPort;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveCartProductServiceImpl implements SaveCartProductService {

    private CartProductPort cartProductPort;
    @Override
    public CartProductBO run(CartProductBO cartProduct) {
        return cartProductPort.save(cartProduct);
    }
}

