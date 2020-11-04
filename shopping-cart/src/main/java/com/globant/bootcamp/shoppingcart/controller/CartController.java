package com.globant.bootcamp.shoppingcart.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.globant.bootcamp.shoppingcart.dto.CartDto;
import com.globant.bootcamp.shoppingcart.dto.CartMapper;
import com.globant.bootcamp.shoppingcart.model.Cart;
import com.globant.bootcamp.shoppingcart.model.Product;
import com.globant.bootcamp.shoppingcart.service.CartServiceInMem;
import com.globant.bootcamp.shoppingcart.service.ProductServiceInMem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CartController {

	@Autowired
	private ProductServiceInMem products;
	@Autowired
	private CartServiceInMem carts;

	@PostMapping("/carts")
	public CartDto addCart(@RequestBody CartDto cart) {
		Cart newCart = carts.addCart(CartMapper.INSTANCE.convert(cart));
		return CartMapper.INSTANCE.convert(newCart);
	}

	@GetMapping("/carts/{cart_id}")
	public CartDto getCart(@PathVariable("cart_id") long cartId) {
		Cart cart = carts.getCart(cartId);
		return CartMapper.INSTANCE.convert(cart);
	}

	@DeleteMapping("/carts/{cart_id}")
	public void removeCart(@PathVariable("cart_id") long cartId) {
		carts.removeCart(cartId);
	}

	@GetMapping("/carts")
	public List<CartDto> getAllCarts() {
		return carts.getCarts().stream().map(c -> CartMapper.INSTANCE.convert(c)).collect(Collectors.toList());
	}

	@PutMapping("/carts/{cart_id}/products/{product_id}")
	public CartDto addProduct(@PathVariable("cart_id") long cartId, @PathVariable("product_id") long productId) {
		Product p = products.get(productId);
		Cart cart = carts.addProduct(cartId, p);
		return CartMapper.INSTANCE.convert(cart);
	}

	@DeleteMapping("/carts/{cart_id}/products/{product_id}")
	public CartDto removeProduct(@PathVariable("cart_id") long cartId, @PathVariable("product_id") long productId) {
		Product product = products.get(productId);
		Cart cart = carts.removeProduct(cartId, product);
		return CartMapper.INSTANCE.convert(cart);
	}
}
