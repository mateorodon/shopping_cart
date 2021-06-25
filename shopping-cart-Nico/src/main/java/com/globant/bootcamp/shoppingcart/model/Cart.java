package com.globant.bootcamp.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;


public class Cart {
    private int id;
    private List<Product> productList;

    public Cart(int id){
        this.id = id;
        this.productList = new ArrayList<>();
    }
    public Cart(int id, List<Product> productList){
        this.id = id;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public boolean addProduct(Product product){
        this.productList.add(product);
        return true;
    }

    public Product getProduct(int id) {
        for (Product product : this.productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProductList() {
        if (this.productList == null)
            this.productList = new ArrayList<>();
        return this.productList;
    }
}
