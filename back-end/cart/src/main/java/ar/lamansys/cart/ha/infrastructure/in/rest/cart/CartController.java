package ar.lamansys.cart.ha.infrastructure.in.rest.cart;


import ar.lamansys.cart.ha.infrastructure.in.rest.cart_product.CartProductDTORequest;
import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.interfaces.AddCartProductService;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hb.application.user.exceptions.UserDoesNotExistException;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private AddCartProductService addCartProductService;

    @PutMapping("/{userId}")
    public void addProduct(@PathVariable Integer userId, @RequestBody CartProductDTORequest product)
            throws UserDoesNotExistException, ProductDoesNotExistException, StockNotAvailableException, CartDoesNotExistException {
        CartProductBO cartProductBO = new CartProductBO(product.getProduct_id(), product.getAmount());
        addCartProductService.run(userId,cartProductBO);
    }
}
