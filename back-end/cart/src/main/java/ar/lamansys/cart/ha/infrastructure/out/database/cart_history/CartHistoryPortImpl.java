package ar.lamansys.cart.ha.infrastructure.out.database.cart_history;

import ar.lamansys.cart.hb.application.cart_history.port.CartHistoryPort;
import ar.lamansys.cart.hc.domain.cart_history.CartHistoryBO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Primary
public class CartHistoryPortImpl implements CartHistoryPort {

    CartHistoryRepository cartHistoryRepository;
    @Override
    public CartHistoryBO save(CartHistoryBO cart) {
        return CartHistoryMapperJPA.toCartHistoryBO(cartHistoryRepository.save(CartHistoryMapperJPA.toCartHistoryEntity(cart)));
    }
}
