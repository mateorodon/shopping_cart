package ar.lamansys.cart.hb.application.cart_history.port;

import ar.lamansys.cart.hc.domain.cart_history.CartHistoryBO;

public interface CartHistoryPort {

    CartHistoryBO save(CartHistoryBO cart);
}
