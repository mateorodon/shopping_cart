package ar.lamansys.cart.hb.application.cart_history.implementation;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.interfaces.GetMontoTotalService;
import ar.lamansys.cart.hb.application.cart_history.interfaces.SaveCartHistoryService;
import ar.lamansys.cart.hb.application.cart_history.port.CartHistoryPort;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import ar.lamansys.cart.hc.domain.cart_history.CartHistoryBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class SaveCartHistoryServiceImpl implements SaveCartHistoryService {

    GetMontoTotalService getMontoTotalService;
    private CartHistoryPort cartHistoryPort;

    @Override
    public CartHistoryBO run(CartBO cart) throws ProductDoesNotExistException, CartDoesNotExistException {
        BigDecimal final_price = getMontoTotalService.run(cart.getCart_id(),cart.getUser_id());
        return cartHistoryPort.save(new CartHistoryBO(cart.getCart_id(),cart.getUser_id(),LocalDate.now(),final_price));
    }
}
