package com.globant.bootcamp.shoppingcart.service;

import com.globant.bootcamp.shoppingcart.model.Cart;
import com.globant.bootcamp.shoppingcart.model.Product;

public interface CartService {

    boolean addCart(Cart cart);

    boolean deleteCart(int id);

    Cart getCart(int id);

    Cart addProduct(int id, Product product);

}
