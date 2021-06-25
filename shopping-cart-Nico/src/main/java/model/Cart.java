package model;

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

    public Product getProduct(int id) {
        for (Product product : this.productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProductList() {
        List<Product> auxProductList = new ArrayList<>(this.productList);
        return auxProductList;
    }
}
