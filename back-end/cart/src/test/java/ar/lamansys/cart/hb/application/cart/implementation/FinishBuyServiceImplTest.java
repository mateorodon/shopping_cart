package ar.lamansys.cart.hb.application.cart.implementation;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.*;

class FinishBuyServiceImplTest {

    private CartPort cartPort = Mockito.mock(CartPort.class);
    private GetCartProductsService getCartProductsService = Mockito.mock(GetCartProductsService.class);
    private FindProductService findProductService = Mockito.mock(FindProductService.class);
    private UpdateStockService updateStockService = Mockito.mock(UpdateStockService.class);
    private SaveCartHistoryService saveCartHistoryService = Mockito.mock(SaveCartHistoryService.class);

    private FinishBuyServiceImpl finishBuyService =
            new FinishBuyServiceImpl(cartPort,getCartProductsService,findProductService,updateStockService,saveCartHistoryService);

    @Test
    void productoStockNegativo_run_cancelaFinalizacionYLanzaExcepcion() throws ProductDoesNotExistException, StockNotAvailableException, CartDoesNotExistException {
        //Arrange
        Integer user_id = 1;
        Integer cart_id = 1;
        Integer stock = 5;
        Integer amount = 6;
        CartBO cartBO = new CartBO(cart_id,user_id,false);
        ProductBO product1 = new ProductBO(1,"product1",stock, BigDecimal.valueOf(15));
        List<CartProductBO> products = List.of
                (new CartProductBO(1,cart_id,user_id,amount));
        cartBO.setProducts(products);
        when(cartPort.findByUser_id(user_id))
                .thenReturn(cartBO);
        when(getCartProductsService.run(cart_id,user_id))
                .thenReturn(products);
        when(findProductService.run(1))
                .thenReturn(product1);
        doThrow(StockNotAvailableException.class)
                .when(updateStockService).run(product1,amount);

        //Act
        Throwable throwable = catchThrowable(
                () -> finishBuyService.run(user_id)
        );

        //Assert
        verify(cartPort,times(1)).findByUser_id(user_id);
        verify(getCartProductsService,times(1)).run(cart_id,user_id);
        verify(findProductService, times(1)).run(user_id);
        verify(updateStockService,times(1)).run(product1,amount);
        verify(saveCartHistoryService,times(0)).run(any(CartBO.class));
        verify(cartPort,times(0)).save(any(CartBO.class));

        assertThat(throwable)
                .as("Chequeo para invalidar stock negativo")
                .isNotNull()
                .isInstanceOf(StockNotAvailableException.class);
    }

    @Test
    void carritoConDatosValidos_run_guardaEnHistorialYFinalizaCarrito() throws ProductDoesNotExistException, StockNotAvailableException, CartDoesNotExistException {
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
        doNothing().when(updateStockService).run(product1,1);
        doNothing().when(updateStockService).run(product2,2);

        //Act
        finishBuyService.run(user_id);

        //Assert
        verify(cartPort,times(1)).findByUser_id(user_id);
        verify(getCartProductsService,times(1)).run(cart_id,user_id);
        verify(findProductService, times(2)).run(anyInt());
        verify(updateStockService,times(2)).run(any(ProductBO.class),anyInt());
        verify(saveCartHistoryService,times(1)).run(cartBO);
        verify(cartPort,times(1)).save(cartBO);

        assertThat(cartBO)
                .as("Chequea estado de finalizacion carrito")
                .extracting("finalized")
                .isEqualTo(true);
    }
}