package ar.lamansys.cart.hb.application.user.port;

import ar.lamansys.cart.hc.domain.user.UserBO;

public interface UserPort {
    UserBO save(UserBO user);
    boolean exists(Integer user_id);
}
