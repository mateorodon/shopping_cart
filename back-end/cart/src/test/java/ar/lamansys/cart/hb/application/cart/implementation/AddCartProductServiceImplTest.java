package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.port.CartPort;
import ar.lamansys.cart.hb.application.cart_product.interfaces.SaveCartProductService;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hb.application.product.interfaces.CheckStockService;
import ar.lamansys.cart.hb.application.product.interfaces.FindProductService;
import ar.lamansys.cart.hb.application.user.exceptions.UserDoesNotExistException;
import ar.lamansys.cart.hb.application.user.interfaces.FindUserService;
import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import ar.lamansys.cart.hc.domain.user.UserBO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

//import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.*;


import java.math.BigDecimal;

class AddCartProductServiceImplTest {
    private CartPort cartPort = Mockito.mock(CartPort.class);
    private FindUserService findUserService = Mockito.mock(FindUserService.class);
    private FindProductService findProductService = Mockito.mock(FindProductService.class);
    private CheckStockService checkStockService = Mockito.mock(CheckStockService.class);
    private SaveCartProductService saveCartProductService = Mockito.mock(SaveCartProductService.class);
    AddCartProductServiceImpl addCartProductService =
            new AddCartProductServiceImpl(cartPort,findUserService,findProductService,checkStockService,saveCartProductService);


    @Test
    void productoExcedeStockDisponible_run_noAgregaProductoYLanzaExcepcion()
            throws UserDoesNotExistException, ProductDoesNotExistException, StockNotAvailableException {
        //Arrange
        Integer user_id = 1;
        Integer product_id = 1;
        ProductBO product = new ProductBO(product_id, "product1", 20, BigDecimal.valueOf(15));
        CartProductBO cartProduct = new CartProductBO(product_id, 25);
        UserBO userBO = new UserBO(user_id, "user1");
        when(findUserService.run(user_id))
                .thenReturn(userBO);
        when(findProductService.run(product_id))
                .thenReturn(product);
        when(checkStockService.run(cartProduct.getAmount(),product))
                .thenThrow(StockNotAvailableException.class);

        //Act
        Throwable throwable = catchThrowable(
                () -> addCartProductService.run(user_id,cartProduct)
        );

        //Assert
        verify(findUserService, times(1)).run(user_id);
        verify(findProductService, times(1)).run(product_id);
        verify(cartPort, times(0)).findByUser_id(user_id);
        verify(saveCartProductService, times(0)).run(any(CartProductBO.class));

        assertThat(throwable)
                .as("Chequea stock del producto")
                .isNotNull()
                .isInstanceOf(StockNotAvailableException.class);


    }

    @Test
    void carritoNoExiste_run_creaCarritoYAgregaProducto(){

    }

    /*@Test
    void usuarioNoExiste_run_LanzaExcepcion(){

    }*/
}