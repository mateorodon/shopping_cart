package com.globant.bootcamp.shoppingcart.service;

import com.globant.bootcamp.shoppingcart.model.Cart;
import com.globant.bootcamp.shoppingcart.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartServiceMem implements CartService{
    List<Cart> carts = new ArrayList<>();

    @Override
    public boolean addCart(Cart cart) {
        for (Cart cart1:this.carts) {
            if(cart.getId() == cart1.getId()){
                System.out.println("El id ya existe");
                return false;
            }
        }
        this.carts.add(cart);
        return true;
    }

    @Override
    public boolean deleteCart(int id) {
        for (Cart cart1:this.carts) {
            if(id == cart1.getId()){
                return this.carts.remove(cart1);
            }
        }
        System.out.println("El id no existe");
        return true;
    }

    @Override
    public Cart getCart(int id) {
        for (Cart cart1:this.carts) {
            if(id == cart1.getId()){
                return cart1;
            }
        }
        System.out.println("El id no existe");
        return null;
    }

    @Override
    public Cart addProduct(int id,Product product) {
        for (Cart cart1:this.carts) {
            if(id== cart1.getId()){
                cart1.setProduct(product);
                return cart1;
            }
        }
        System.out.println("El id no existe");
        return null;
    }
}
