package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.interfaces.RemoveCartProductService;
import ar.lamansys.cart.hb.application.cart.port.CartPort;
import ar.lamansys.cart.hb.application.cart_product.exceptions.CartProductDoesNotExistException;
import ar.lamansys.cart.hb.application.cart_product.interfaces.DeleteCartProductService;
import ar.lamansys.cart.hb.application.cart_product.interfaces.FindCartProductService;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.interfaces.FindProductService;
import ar.lamansys.cart.hb.application.user.exceptions.UserDoesNotExistException;
import ar.lamansys.cart.hb.application.user.interfaces.FindUserService;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RemoveCartProductServiceImpl implements RemoveCartProductService {

    private CartPort cartPort;
    private FindUserService findUserService;
    private FindProductService findProductService;
    private DeleteCartProductService deleteCartProductService;
    private FindCartProductService findCartProductService;

    @Override
    public void run(Integer user_id, Integer product_id)
            throws UserDoesNotExistException, ProductDoesNotExistException, CartDoesNotExistException, CartProductDoesNotExistException {
        if (!findUserService.run(user_id)){
            throw new UserDoesNotExistException(user_id);
        }
        ProductBO productBo = findProductService.run(product_id);//tira excepcion si no existe
        CartBO cart = cartPort.findByUser_id(user_id);
        if (cart==null)
            throw new CartDoesNotExistException(user_id);
        CartProductBO cartProduct = findCartProductService.run(product_id,cart.getCart_id(), cart.getUser_id());
        deleteCartProductService.run(cartProduct);
    }
}
