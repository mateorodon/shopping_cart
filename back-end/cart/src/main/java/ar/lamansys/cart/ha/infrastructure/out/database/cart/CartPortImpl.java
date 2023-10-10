package ar.lamansys.cart.ha.infrastructure.out.database.cart;

import ar.lamansys.cart.hb.application.cart.port.CartPort;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
@Primary
public class CartPortImpl implements CartPort {

    private CartRepository cartRepository;

    @Override
    public CartBO save(CartBO cart) {
        return CartMapperJPA.toCartBO(cartRepository.save(CartMapperJPA.toCartEntity(cart)));
    }

    @Override
    public boolean exists(Integer cart_id, Integer user_id) {
        CartID cartId = new CartID(cart_id,user_id);
        return cartRepository.existsById(cartId);
    }

    @Override
    public Optional<CartBO> findById(Integer cart_id, Integer user_id) {
        CartID cartId = new CartID(cart_id,user_id);
        return cartRepository.findById(cartId).map(CartMapperJPA::toCartBO);
    }

    @Override
    public CartBO findByUser_id(Integer user_id) {
        /*try {
            Integer cart_id = cartRepository.getCartId(user_id);
            return new CartBO(cart_id, user_id);
        }
        catch (Exception e){
            return null;
        }*/
        Integer cart_id = cartRepository.getCartId(user_id);
        if (cart_id == null){
            return null;
        }
        else {
            return new CartBO(cart_id, user_id);
        }

    }

}
