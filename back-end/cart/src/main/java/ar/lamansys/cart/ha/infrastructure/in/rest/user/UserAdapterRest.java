package ar.lamansys.cart.ha.infrastructure.in.rest.user;

import ar.lamansys.cart.ha.infrastructure.in.rest.user.dto.UserDTORequest;
import ar.lamansys.cart.ha.infrastructure.in.rest.user.dto.UserDTOResponse;
import ar.lamansys.cart.hc.domain.user.UserBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAdapterRest {

    UserDTOResponse toUserDTOResponse(UserBO user);
    UserBO toUserBO(UserDTORequest user);
}
