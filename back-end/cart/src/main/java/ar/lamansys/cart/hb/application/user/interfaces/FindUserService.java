package ar.lamansys.cart.hb.application.user.interfaces;

import ar.lamansys.cart.hb.application.user.exceptions.UserDoesNotExistException;
import ar.lamansys.cart.hc.domain.user.UserBO;

public interface FindUserService {

    UserBO run(Integer id) throws UserDoesNotExistException;
}
