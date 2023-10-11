package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.interfaces.AddCartProductService;
import ar.lamansys.cart.hb.application.cart.port.CartPort;
import ar.lamansys.cart.hb.application.cart_product.interfaces.SaveCartProductService;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hb.application.product.interfaces.CheckStockService;
import ar.lamansys.cart.hb.application.product.interfaces.FindProductService;
import ar.lamansys.cart.hb.application.user.exceptions.UserDoesNotExistException;
import ar.lamansys.cart.hb.application.user.interfaces.FindUserService;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
@AllArgsConstructor
public class AddCartProductServiceImpl implements AddCartProductService {


    private CartPort cartPort;
    private FindUserService findUserService;
    private FindProductService findProductService;
    private CheckStockService checkStockService;
    private SaveCartProductService saveCartProductService;

    @Override
    public CartProductBO run(Integer user_id, CartProductBO product)
            throws UserDoesNotExistException, ProductDoesNotExistException, StockNotAvailableException, CartDoesNotExistException {
        if (!findUserService.run(user_id)){
            throw new UserDoesNotExistException(user_id);
        }
        ProductBO productBo = findProductService.run(product.getProduct_id());//tira excepcion si no existe
        checkStockService.run(product.getAmount(), productBo); //tira excepcion si no hay stock
        CartBO cart = cartPort.findByUser_id(user_id);//chequeamos si el user ya tiene cart
        if (cart == null){
            CartBO newCart = new CartBO(user_id,user_id);
            cartPort.save(newCart);
            cart = newCart;
        }
        product.setCart_id(cart.getCart_id());
        product.setUser_id(user_id);
        cart.addProduct(product);
        return saveCartProductService.run(product);
    }
}
