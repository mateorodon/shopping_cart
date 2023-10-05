package ar.lamansys.cart.hb.application.user.interfaces;

import ar.lamansys.cart.hb.application.user.exceptions.NotUniqueUserException;
import ar.lamansys.cart.hc.domain.user.UserBO;

public interface SaveUserService {
    UserBO run(UserBO user) throws NotUniqueUserException;
}
