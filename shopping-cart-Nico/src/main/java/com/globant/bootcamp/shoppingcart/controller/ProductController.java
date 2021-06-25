package com.globant.bootcamp.shoppingcart.controller;
import com.globant.bootcamp.shoppingcart.model.Product;
import com.globant.bootcamp.shoppingcart.service.ProductServiceMem;
import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class ProductController {
    ProductServiceMem productSearcher = new ProductServiceMem();

    //MAS ADELANTE LOS MODELOS VAN A SET Dto
    @PostMapping("/products")
    public boolean  product(@RequestBody(required = true) Product product) {
        return this.productSearcher.addProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable(required = true) int id){
        Product productSearched = productSearcher.getProduct(id);
        return productSearched;
    }

    @PutMapping("/product")
    public Product setProduct(
            @RequestBody(required = true) int id,
            @RequestBody(required = true) String description,
            @RequestBody(required = false) String lote,
            @RequestBody(required = false) LocalDate expiresIn){
        return this.productSearcher.setProduct(id,description,lote,expiresIn);
    }

    @DeleteMapping("/product/{id}")
    public boolean deleteProduct(@PathVariable(required = true) int id){
        return productSearcher.deleteProduct(id);
    }
}
