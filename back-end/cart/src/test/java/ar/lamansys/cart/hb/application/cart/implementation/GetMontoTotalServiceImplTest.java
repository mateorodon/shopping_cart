package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.interfaces.GetCartProductsService;
import ar.lamansys.cart.hb.application.cart.port.CartPort;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.interfaces.FindProductService;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class GetMontoTotalServiceImplTest {

    private CartPort cartPort = Mockito.mock(CartPort.class);
    private FindProductService findProductService = Mockito.mock(FindProductService.class);
    private GetCartProductsService getCartProductsService = Mockito.mock(GetCartProductsService.class);

    private GetMontoTotalServiceImpl getMontoTotalService =
            new GetMontoTotalServiceImpl(cartPort,findProductService,getCartProductsService);


    @Test
    void carritoContieneProductos_run_devuelveMontoTotal() throws ProductDoesNotExistException, CartDoesNotExistException {
        Integer user_id = 1;
        Integer cart_id = 1;
        CartBO cartBO = new CartBO(cart_id,user_id,false);
        ProductBO product1 = new ProductBO(1,"product1",5, BigDecimal.valueOf(15));
        ProductBO product2 = new ProductBO(2,"product2",5, BigDecimal.valueOf(4.5));
        List<CartProductBO> products = List.of
                (new CartProductBO(1,cart_id,user_id,1),
                 new CartProductBO(2,cart_id,user_id,2));
        cartBO.setProducts(products);
        when(cartPort.findByUser_id(user_id))
                .thenReturn(cartBO);
        when(getCartProductsService.run(cart_id,user_id))
                .thenReturn(products);
        when(findProductService.run(1))
                .thenReturn(product1);
        when(findProductService.run(2))
                .thenReturn(product2);

        //Act
        BigDecimal total = getMontoTotalService.run(cart_id,user_id);

        //Assert
        verify(cartPort,times(1)).findByUser_id(user_id);
        verify(getCartProductsService,times(1)).run(cart_id,user_id);
        verify(findProductService,times(2)).run(anyInt());

        assertThat(total)
                .as("Chequeo monto total de productos")
                .isEqualByComparingTo(BigDecimal.valueOf(24));

    }

    @Test
    void carritoFinalizado_run_lanzaExcepcion() throws ProductDoesNotExistException {
        Integer user_id = 1;
        Integer cart_id = 1;
        CartBO cartBO = new CartBO(cart_id,user_id,true);
        when(cartPort.findByUser_id(user_id))
                .thenReturn(null);

        //Act
        Throwable throwable = catchThrowable(
                () -> getMontoTotalService.run(cart_id,user_id)
        );

        //Assert
        verify(cartPort, times(1)).findByUser_id(user_id);
        verify(getCartProductsService,times(0)).run(cart_id,user_id);
        verify(findProductService,times(0)).run(anyInt());

        assertThat(throwable)
                .as("Chequeo estado de carrito")
                .isNotNull()
                .isInstanceOf(CartDoesNotExistException.class);

    }

}