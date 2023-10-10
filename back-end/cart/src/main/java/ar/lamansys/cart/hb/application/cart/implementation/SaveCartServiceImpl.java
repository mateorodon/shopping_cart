package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.exceptions.NotUniqueCartException;
import ar.lamansys.cart.hb.application.cart.interfaces.SaveCartService;
import ar.lamansys.cart.hb.application.cart.port.CartPort;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveCartServiceImpl implements SaveCartService {
    private CartPort cartPort;


    @Override
    public CartBO run(CartBO cart) throws NotUniqueCartException {
        if (cartPort.exists(cart.getCart_id(), cart.getUser_id())) {
            throw new NotUniqueCartException(cart.getUser_id());
        }
        return cartPort.save(cart);
    }
}
