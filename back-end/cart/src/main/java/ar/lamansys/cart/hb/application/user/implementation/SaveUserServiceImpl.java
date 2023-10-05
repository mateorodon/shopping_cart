package ar.lamansys.cart.hb.application.user.implementation;

import ar.lamansys.cart.hb.application.user.exceptions.NotUniqueUserException;
import ar.lamansys.cart.hb.application.user.interfaces.SaveUserService;
import ar.lamansys.cart.hb.application.user.port.UserPort;
import ar.lamansys.cart.hc.domain.user.UserBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveUserServiceImpl implements SaveUserService {

    private UserPort userPort;
    @Override
    public UserBO run(UserBO user) throws NotUniqueUserException {
        if (userPort.exists(user.getUser_id())){
            throw new NotUniqueUserException(user.getUsername());
        }
        return userPort.save(user);
    }
}
