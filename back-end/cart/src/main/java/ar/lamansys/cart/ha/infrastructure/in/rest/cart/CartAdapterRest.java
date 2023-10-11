package ar.lamansys.cart.ha.infrastructure.in.rest.cart;

import ar.lamansys.cart.ha.infrastructure.in.rest.cart.dto.CartDTOResponse;
import ar.lamansys.cart.hc.domain.cart.CartBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartAdapterRest {

    CartDTOResponse toCartDTOResponse(CartBO cart);

    //CartBO toCartBO(CartDTORequest cart);
}
