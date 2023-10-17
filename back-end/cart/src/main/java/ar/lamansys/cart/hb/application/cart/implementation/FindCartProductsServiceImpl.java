package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.interfaces.FindCartProductsService;
import ar.lamansys.cart.hb.application.cart.interfaces.GetCartProductsService;
import ar.lamansys.cart.hb.application.cart.port.CartPort;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindCartProductsServiceImpl implements FindCartProductsService {
    CartPort cartPort;
    GetCartProductsService getCartProductsService;

    @Override
    public CartBO run(Integer user_id) throws CartDoesNotExistException {
        CartBO out = cartPort.findByUser_id(user_id);
        if (out== null)
            throw new CartDoesNotExistException(user_id);
        out.setProducts(getCartProductsService.run(out.getCart_id(),out.getUser_id()));
        return out;
    }
}
