package com.globant.bootcamp.shoppingcart.service;

import com.globant.bootcamp.shoppingcart.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface ProductService {

    boolean addProduct(Product product);

    boolean deleteProduct(int id);

    Product getProduct(int id);

    Product setProduct(Product product);

}
