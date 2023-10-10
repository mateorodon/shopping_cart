package ar.lamansys.cart.ha.infrastructure.out.database.cart_product;

import ar.lamansys.cart.hb.application.cart_product.port.CartProductPort;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Primary
public class CartProductPortImpl implements CartProductPort {

    private CartProductRepository cartProductRepository;

    @Override
    public CartProductBO save(CartProductBO cartProduct) {
        return CartProductMapperJPA.toCartProductBO(cartProductRepository.save(CartProductMapperJPA.toCartProductEntity(cartProduct)));
    }
}
