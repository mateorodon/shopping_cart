package com.globant.bootcamp.shoppingcart.service;

import com.globant.bootcamp.shoppingcart.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceMem implements ProductService{

    List<Product> products = new ArrayList<>();
    @Override
    public boolean addProduct(Product product) {
        for (Product product1:this.products) {
            if(product.getId() == product1.getId()){
                System.out.println("El id ya existe");
                return false;
            }
        }
        this.products.add(product);
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        for (Product product:this.products) {
            if(id == product.getId()){
                return this.products.remove(product);
            }
        }
        System.out.println("El id no existe");
        return false;
    }

    @Override
    public Product getProduct(int id) {
        for (Product product:this.products) {
            if(id == product.getId()){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product setProduct(Product product){
        for (Product product1:this.products) {
            if(product.getId() == product1.getId()){
                product.setDescription(product.getDescription());
                product.setLote(product.getLote());
                product.setExpiresIn(product.getExpiresIn());
                return product;
            }
        }
        return null;
    }
}
