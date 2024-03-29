package ar.lamansys.cart.hc.domain.cart;

import ar.lamansys.cart.hc.domain.cart_product.CartProductBO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class CartBO {

    private Integer cart_id;
    private Integer user_id;
    private List<CartProductBO> products;
    private boolean finalized;

    public CartBO(Integer user_id){
        this.cart_id = 0;
        this.user_id = user_id;
        products = new ArrayList<>();
        finalized = false;
    }
    public CartBO(Integer cart_id,Integer user_id,boolean finalized){
        this.cart_id = cart_id;
        this.user_id = user_id;
        products = new ArrayList<>();
        this.finalized = finalized;
    }
    public CartBO(){
        products = new ArrayList<>();
        finalized = false;
    }

    public void addProduct(CartProductBO product){
        products.add(product);
    }
}
