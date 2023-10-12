package ar.lamansys.cart.ha.infrastructure.in.rest.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MontoTotalCartDTOResponse {

    CartDTOResponse cart;
    BigDecimal montoTotal;
}
