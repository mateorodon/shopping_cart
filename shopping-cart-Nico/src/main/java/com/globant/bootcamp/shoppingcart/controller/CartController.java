package com.globant.bootcamp.shoppingcart.controller;
import com.globant.bootcamp.shoppingcart.dto.CartDto;
import com.globant.bootcamp.shoppingcart.model.Cart;
import com.globant.bootcamp.shoppingcart.model.Product;
import com.globant.bootcamp.shoppingcart.service.CartServiceMem;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {
    CartServiceMem cartSearcher = new CartServiceMem();

    //MAS ADELANTE LOS MODELOS VAN A SET Dto
    @PostMapping
    public boolean cart(@RequestBody(required = true) CartDto cart) {
        Cart cart1 = new Cart(cart.getId());
        return this.cartSearcher.addCart(cart1);
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable(required = true) int id){
        Cart cart1 = this.cartSearcher.getCart(id);
        return cart1;
    }

    @GetMapping("/{id}/products")
    public List<Product> getProducts(@PathVariable(required = true) int id){
        Cart cart1 = this.cartSearcher.getCart(id);
        if(cart1 != null){
            return cart1.getProductList();
        }
        return null;
    }

    @PostMapping("/{id}/products/add")
    public Cart setProduct(@PathVariable(required = true) int id, @RequestBody Product product){
        return this.cartSearcher.addProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCart(@PathVariable(required = true) int id){
        return this.cartSearcher.deleteCart(id);
    }

}
