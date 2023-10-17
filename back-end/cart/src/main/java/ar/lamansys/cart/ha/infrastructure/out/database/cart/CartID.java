package ar.lamansys.cart.ha.infrastructure.out.database.cart;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CartID implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cart_id;
    Integer user_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartID cartID = (CartID) o;
        return Objects.equals(cart_id, cartID.cart_id) &&
                Objects.equals(user_id, cartID.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart_id,user_id);
    }
}
