package ar.lamansys.cart.ha.infrastructure.in.rest;

import ar.lamansys.cart.hb.application.cart.exceptions.CartDoesNotExistException;
import ar.lamansys.cart.hb.application.cart.exceptions.NotUniqueCartException;
import ar.lamansys.cart.hb.application.cart_product.exceptions.CartProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.NotUniqueProductException;
import ar.lamansys.cart.hb.application.product.exceptions.ProductDoesNotExistException;
import ar.lamansys.cart.hb.application.product.exceptions.StockNotAvailableException;
import ar.lamansys.cart.hb.application.user.exceptions.NotUniqueUserException;
import ar.lamansys.cart.hb.application.user.exceptions.UserDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> run(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDTO(
                        "error_general",
                        "problemas con la consulta"
                ));
    }

    //CART
    @ExceptionHandler(CartDoesNotExistException.class)
    public ResponseEntity<ErrorDTO> run(CartDoesNotExistException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(
                        "cart_does_not_exist",
                        "el carrito que desea buscar no existe"
                ));
    }

    @ExceptionHandler(NotUniqueCartException.class)
    public ResponseEntity<ErrorDTO> run(NotUniqueCartException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(
                        "not_unique_cart",
                        "el carrito ya existe"
                ));
    }

    //CART_PRODUCT
    @ExceptionHandler(CartProductDoesNotExistException.class)
    public ResponseEntity<ErrorDTO> run(CartProductDoesNotExistException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(
                        "product_does_not_exist",
                        "no se encontró el producto en el carrito"
                ));
    }

    //PRODUCT
    @ExceptionHandler(NotUniqueProductException.class)
    public ResponseEntity<ErrorDTO> run(NotUniqueProductException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(
                        "not_unique_product",
                        "el producto con el id indicado ya existe"
                ));
    }

    @ExceptionHandler(ProductDoesNotExistException.class)
    public ResponseEntity<ErrorDTO> run(ProductDoesNotExistException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(
                        "product_does_not_exist",
                        "el producto que desea buscar no existe"
                ));
    }

    @ExceptionHandler(StockNotAvailableException.class)
    public ResponseEntity<ErrorDTO> run(StockNotAvailableException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(
                        "stock_not_available",
                        "no hay suficiente stock del producto indicado"
                ));
    }

    //USER
    @ExceptionHandler(NotUniqueUserException.class)
    public ResponseEntity<ErrorDTO> run(NotUniqueUserException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(
                        "not_unique_user",
                        "el usuario con el id indicado ya existe"
                ));
    }

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<ErrorDTO> run(UserDoesNotExistException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(
                        "user_does_not_exist",
                        "el usuario que desea buscar no existe"
                ));
    }

}
