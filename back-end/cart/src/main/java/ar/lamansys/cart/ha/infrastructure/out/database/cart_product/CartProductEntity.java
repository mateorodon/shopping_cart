package ar.lamansys.cart.ha.infrastructure.out.database.cart_product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cart_product")

public class CartProductEntity {

    @EmbeddedId
    CartProductID cartProductID;
    Integer amount;

}
