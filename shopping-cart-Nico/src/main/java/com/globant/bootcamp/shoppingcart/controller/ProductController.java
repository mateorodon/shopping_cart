package com.globant.bootcamp.shoppingcart.controller;
import com.globant.bootcamp.shoppingcart.dto.ProductDto;
import com.globant.bootcamp.shoppingcart.model.Product;
import com.globant.bootcamp.shoppingcart.service.ProductServiceMem;
import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {
    ProductServiceMem productSearcher = new ProductServiceMem();

    //MAS ADELANTE LOS MODELOS VAN A SET Dto
    @PostMapping
    public boolean  product(@RequestBody(required = true) Product product) {
        return this.productSearcher.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable(required = true) int id){
        Product productSearched = productSearcher.getProduct(id);
        return productSearched;
    }

    @PutMapping
    public Product setProduct(@RequestBody(required = true) ProductDto product){
        Product product1 = new Product(
                product.getId(),
                product.getDescription(),
                product.getExpiresIn(),
                product.getLote()
        );
        return this.productSearcher.setProduct(product1);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable(required = true) int id){
        return productSearcher.deleteProduct(id);
    }
}
