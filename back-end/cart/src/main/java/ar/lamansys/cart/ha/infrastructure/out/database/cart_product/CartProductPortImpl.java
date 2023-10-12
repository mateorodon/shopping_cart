package ar.lamansys.cart.ha.infrastructure.out.database.cart_product;

import ar.lamansys.cart.hb.application.cart_product.port.CartProductPort;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@Primary
public class CartProductPortImpl implements CartProductPort {

    private CartProductRepository cartProductRepository;

    @Override
    public CartProductBO save(CartProductBO cartProduct) {
        return CartProductMapperJPA.toCartProductBO(cartProductRepository.save(CartProductMapperJPA.toCartProductEntity(cartProduct)));
    }

    @Override
    public List<CartProductBO> getCartProducts(Integer cart_id, Integer user_id){
        List<CartProductEntity> entities = cartProductRepository.getCartProducts(cart_id,user_id);
        return entities.stream()
                .map(CartProductMapperJPA::toCartProductBO)
                        .collect(Collectors.toList());
    }

    @Override
    public void delete(CartProductBO cartProduct) {
        cartProductRepository.delete(CartProductMapperJPA.toCartProductEntity(cartProduct));
    }

    @Override
    public Optional<CartProductBO> findById(Integer product_id,Integer cart_id,Integer user_id) {
        CartProductID cartProductId = new CartProductID(product_id,cart_id,user_id);
        return cartProductRepository.findById(cartProductId).map(CartProductMapperJPA::toCartProductBO);
    }
}
