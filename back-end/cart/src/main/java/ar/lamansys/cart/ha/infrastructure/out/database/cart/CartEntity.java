package ar.lamansys.cart.ha.infrastructure.out.database.cart;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cart_id;
    Integer user_id;
    /*@AttributeOverrides({
            @AttributeOverride(name = "cart_id", column = @Column(name = "cart_id")),
            @AttributeOverride(name = "user_id", column = @Column(name = "user_id"))
    })*/
    //private CartID cartID;

    private boolean finalized;


}
