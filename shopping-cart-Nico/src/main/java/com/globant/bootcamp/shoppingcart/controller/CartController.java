package com.globant.bootcamp.shoppingcart.controller;
import com.globant.bootcamp.shoppingcart.model.Cart;
import com.globant.bootcamp.shoppingcart.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    //MAS ADELANTE LOS MODELOS VAN A SET Dto
    @PostMapping("/cart")
    public Cart cart(@RequestBody(required = true) Cart cart) {
        //System.out.println("Carrito creado " + cart.getId() + " " + cart.getProductList());
        Cart cart1 = new Cart(cart.getId(), cart.getProductList()); // MOCK DEL SERVICIO
        return cart1;
    }

    @GetMapping("/cart")
    public Cart getCart(@RequestBody(required = true) Cart cart){
        // USAR SERVICIO PARA BUSCAR EL CARRITO
        Cart cart1 = new Cart(cart.getId(), cart.getProductList()); // MOCK DEL SERVICIO
        return cart1;
    }

    @PutMapping("/cart/{id}/products")
    public Cart setProduct(@RequestBody(required = true) Product product){
        // OBTENER CARRITO DESDE LA DB
        return setProduct(product);
        // VOLVER A GUARDARLO
    }

}
