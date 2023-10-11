package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.interfaces.GetCartProductsService;
import ar.lamansys.cart.hb.application.cart_product.port.CartProductPort;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetCartProductsServiceImpl implements GetCartProductsService {

    CartProductPort cartProductPort;

    @Override
    public List<CartProductBO> run(Integer cart_id, Integer user_id) {
        return cartProductPort.getCartProducts(cart_id,user_id);
    }
}
