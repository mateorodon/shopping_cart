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
import ar.lamansys.cart.hc.domain.user.UserBO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.*;

class RemoveCartProductServiceImplTest {

    private CartPort cartPort = Mockito.mock(CartPort.class);
    private FindUserService findUserService = Mockito.mock(FindUserService.class);
    private FindProductService findProductService = Mockito.mock(FindProductService.class);
    private DeleteCartProductService deleteCartProductService = Mockito.mock(DeleteCartProductService.class);
    private FindCartProductService findCartProductService = Mockito.mock(FindCartProductService.class);

    private RemoveCartProductServiceImpl removeCartProductService =
            new RemoveCartProductServiceImpl(cartPort,findUserService,findProductService,deleteCartProductService,findCartProductService);

    @Test
    void carritoNoExiste_run_lanzaExcepcion() throws UserDoesNotExistException, ProductDoesNotExistException, CartProductDoesNotExistException {
        //Arrange
        Integer user_id = 1;
        Integer product_id = 1;
        ProductBO product = new ProductBO(product_id, "product1", 20, BigDecimal.valueOf(15));
        UserBO userBO = new UserBO(user_id, "user1");
        when(findUserService.run(user_id))
                .thenReturn(userBO);
        when(findProductService.run(product_id))
                .thenReturn(product);
        when(cartPort.findByUser_id(user_id))
                .thenReturn(null);

        //Act
        Throwable throwable = catchThrowable(
                () -> removeCartProductService.run(user_id,product_id)
        );

        //Assert
        verify(findUserService, times(1)).run(user_id);
        verify(findProductService, times(1)).run(product_id);
        verify(cartPort, times(1)).findByUser_id(user_id);
        verify(findCartProductService,times(0)).run(anyInt(),anyInt(),anyInt());
        verify(deleteCartProductService,times(0)).run(any(CartProductBO.class));

        assertThat(throwable)
                .as("Chequea existencia del carrito")
                .isNotNull()
                .isInstanceOf(CartDoesNotExistException.class);
    }

    @Test
    void productCartNoExiste_run_lanzaExcepcion() throws UserDoesNotExistException, ProductDoesNotExistException, CartProductDoesNotExistException {
        //Arrange
        Integer user_id = 1;
        Integer product_id = 1;
        Integer cart_id = 1;
        ProductBO product = new ProductBO(product_id, "product1", 20, BigDecimal.valueOf(15));
        UserBO userBO = new UserBO(user_id, "user1");
        CartBO cartBO = new CartBO(cart_id,user_id,false);
        when(findUserService.run(user_id))
                .thenReturn(userBO);
        when(findProductService.run(product_id))
                .thenReturn(product);
        when(cartPort.findByUser_id(user_id))
                .thenReturn(cartBO);
        when(findCartProductService.run(product_id,cart_id,user_id))
                .thenThrow(CartProductDoesNotExistException.class);

        //Act
        Throwable throwable = catchThrowable(
                () -> removeCartProductService.run(user_id,product_id)
        );

        //Assert
        verify(findUserService, times(1)).run(user_id);
        verify(findProductService, times(1)).run(product_id);
        verify(cartPort, times(1)).findByUser_id(user_id);
        verify(findCartProductService,times(1)).run(product_id,cart_id,user_id);
        verify(deleteCartProductService,times(0)).run(any(CartProductBO.class));

        assertThat(throwable)
                .as("Chequea existencia del producto de carrito")
                .isNotNull()
                .isInstanceOf(CartProductDoesNotExistException.class);

    }
}