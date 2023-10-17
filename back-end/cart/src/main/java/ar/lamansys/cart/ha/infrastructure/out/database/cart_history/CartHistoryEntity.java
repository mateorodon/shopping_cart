package ar.lamansys.cart.ha.infrastructure.out.database.cart_history;

import ar.lamansys.cart.ha.infrastructure.out.database.cart.CartID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart_history")
public class CartHistoryEntity{

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "cart_id", column = @Column(name = "cart_id")),
            @AttributeOverride(name = "user_id", column = @Column(name = "user_id"))
    })
    private CartID cartID;
    private LocalDate date;
    private BigDecimal final_price;
}
