package ar.lamansys.cart.ha.infrastructure.out.database.cart_product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartProductID implements Serializable {
    @Column(name = "product_id")
    Integer product_id;
    @Column(name = "cart_id")
    Integer cart_id;
    @Column(name = "user_id")
    Integer user_id;
}
