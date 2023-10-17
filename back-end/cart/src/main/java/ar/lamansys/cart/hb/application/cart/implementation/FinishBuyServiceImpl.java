package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.interfaces.FindCartProductsService;
import ar.lamansys.cart.hb.application.cart.interfaces.FinishBuyService;
import ar.lamansys.cart.hb.application.cart.interfaces.GetCartProductsService;
import ar.lamansys.cart.hb.application.cart.port.CartPort;
import ar.lamansys.cart.hb.application.cart_history.interfaces.SaveCartHistoryService;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hb.application.product.interfaces.FindProductService;
import ar.lamansys.cart.hb.application.product.interfaces.UpdateStockService;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class FinishBuyServiceImpl implements FinishBuyService {


    private CartPort cartPort;
    private GetCartProductsService getCartProductsService;
    private FindProductService findProductService;
    private UpdateStockService updateStockService;
    private SaveCartHistoryService saveCartHistoryService;

    @Override
    public void run(Integer user_id) throws CartDoesNotExistException, ProductDoesNotExistException, StockNotAvailableException {
        CartBO cart = cartPort.findByUser_id(user_id);
        if (cart == null)
            throw new CartDoesNotExistException(user_id);
        List<CartProductBO> products = getCartProductsService.run(cart.getCart_id(),cart.getUser_id());
        for(CartProductBO cp : products){
            ProductBO product = findProductService.run(cp.getProduct_id());
            updateStockService.run(product,cp.getAmount());
        }
        saveCartHistoryService.run(cart);//implementar
        cart.setFinalized(true);
        cartPort.save(cart);
    }
}
