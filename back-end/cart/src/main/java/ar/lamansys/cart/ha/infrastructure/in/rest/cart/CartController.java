package ar.lamansys.cart.ha.infrastructure.in.rest.cart;


import ar.lamansys.cart.ha.infrastructure.in.rest.cart.dto.CartDTOResponse;
import ar.lamansys.cart.ha.infrastructure.in.rest.cart.dto.MontoTotalCartDTOResponse;
import ar.lamansys.cart.ha.infrastructure.in.rest.cart_product.CartProductDTORequest;
import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.interfaces.AddCartProductService;
import ar.lamansys.cart.hb.application.cart.interfaces.FindCartProductsService;
import ar.lamansys.cart.hb.application.cart.interfaces.GetMontoTotalService;
import ar.lamansys.cart.hb.application.cart.interfaces.RemoveCartProductService;
import ar.lamansys.cart.hb.application.cart_product.exceptions.CartProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hb.application.user.exceptions.UserDoesNotExistException;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private CartAdapterRest cartAdapterRest;
    private AddCartProductService addCartProductService;
    private FindCartProductsService findCartProductsService;
    private RemoveCartProductService removeCartProductService;
    private GetMontoTotalService getMontoTotalService;

    @PutMapping("/{userId}")
    public void addProduct(@PathVariable Integer userId, @RequestBody CartProductDTORequest product)
            throws UserDoesNotExistException, ProductDoesNotExistException, StockNotAvailableException, CartDoesNotExistException {
        CartProductBO cartProductBO = new CartProductBO(product.getProduct_id(), product.getAmount());
        addCartProductService.run(userId,cartProductBO);
    }

    @GetMapping("/{userId}")
    public CartDTOResponse getProducts(@PathVariable Integer userId) throws CartDoesNotExistException {
        return cartAdapterRest.toCartDTOResponse(findCartProductsService.run(userId,userId));
    }

    @DeleteMapping("/{userId}/{productId}")
    public void deleteProduct(@PathVariable Integer userId,@PathVariable Integer productId)
            throws ProductDoesNotExistException, UserDoesNotExistException, CartDoesNotExistException, CartProductDoesNotExistException {
        removeCartProductService.run(userId,productId);
    }

    @GetMapping("/montoTotal/{userId}")
    public MontoTotalCartDTOResponse getMontoTotal(@PathVariable Integer userId) throws CartDoesNotExistException, ProductDoesNotExistException {
        CartDTOResponse cart =  cartAdapterRest.toCartDTOResponse(findCartProductsService.run(userId,userId));
        return new MontoTotalCartDTOResponse(cart,getMontoTotalService.run(userId));
    }

}
