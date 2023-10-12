package ar.lamansys.cart.hb.application.cart_product.implementation;

import ar.lamansys.cart.hb.application.cart_product.interfaces.DeleteCartProductService;
import ar.lamansys.cart.hb.application.cart_product.port.CartProductPort;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DeleteCartProductServiceImpl implements DeleteCartProductService {

    private CartProductPort cartProductPort;
    @Override
    public void run(CartProductBO cartProduct) {
        cartProductPort.delete(cartProduct);
    }
}
