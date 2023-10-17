package ar.lamansys.cart.hb.application.user.port;

import ar.lamansys.cart.hc.domain.product.ProductBO;
import ar.lamansys.cart.hc.domain.user.UserBO;

import java.util.Optional;

public interface UserPort {
    UserBO save(UserBO user);
    boolean exists(Integer user_id);

    Optional<UserBO> findById(Integer id);
}
