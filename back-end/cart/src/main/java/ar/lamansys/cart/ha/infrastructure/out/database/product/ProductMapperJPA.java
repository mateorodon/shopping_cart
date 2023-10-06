package ar.lamansys.cart.ha.infrastructure.out.database.product;

import ar.lamansys.cart.ha.infrastructure.out.database.user.UserEntity;
import ar.lamansys.cart.hc.domain.product.ProductBO;
import ar.lamansys.cart.hc.domain.user.UserBO;

public class ProductMapperJPA {

    static public ProductBO toProductBO(ProductEntity product){
        return new ProductBO(product.getProduct_id(),product.getName(), product.getStock(),product.getPrice());
    }
    static public ProductEntity toProductEntity(ProductBO product){
        return new ProductEntity(product.getProduct_id(),product.getName(),product.getStock(),product.getPrice());
    }
}
