package ar.lamansys.cart.ha.infrastructure.out.database.user;

import ar.lamansys.cart.hb.application.user.port.UserPort;
import ar.lamansys.cart.hc.domain.user.UserBO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Primary
public class UserPortImpl implements UserPort {

    private UserRepository userRepository;
    @Override
    public UserBO save(UserBO user) {
        return UserMapperJPA.toUserBO(userRepository.save(UserMapperJPA.toUserEntity(user)));
    }
    @Override
    public boolean exists(Integer user_id) {
        return userRepository.existsById(user_id);
    }
}
