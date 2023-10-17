package ar.lamansys.cart.hc.domain.cart_history;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class CartHistoryBO {

    Integer cart_id;
    Integer user_id;
    LocalDate date;
    BigDecimal final_price;
}
