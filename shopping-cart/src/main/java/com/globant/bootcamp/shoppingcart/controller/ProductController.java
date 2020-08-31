package com.globant.bootcamp.shoppingcart.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.globant.bootcamp.shoppingcart.dto.ProductDto;
import com.globant.bootcamp.shoppingcart.dto.ProductMapper;
import com.globant.bootcamp.shoppingcart.model.Product;
import com.globant.bootcamp.shoppingcart.service.ProductServiceInMem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductServiceInMem products;

	@PostMapping("/products")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product) {
		Product newProduct = products.add(ProductMapper.INSTANCE.convert(product));
		return ResponseEntity.created(null).body(ProductMapper.INSTANCE.convert(newProduct));
	}

	@GetMapping("/products/{product_id}")
	public ProductDto getProduct(@PathVariable("product_id") long productId) {
		Product product = products.get(productId);
		return ProductMapper.INSTANCE.convert(product);
	}

	@DeleteMapping("/products/{product_id}")
	public void removeProduct(@PathVariable("product_id") long productId) {
		products.remove(productId);
	}

	@GetMapping("/products")
	public List<ProductDto> getProducts() {
		List<Product> all = products.getAll();
		return all.stream().map(p -> ProductMapper.INSTANCE.convert(p)).collect(Collectors.toList());
	}

}
