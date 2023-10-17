package ar.lamansys.cart.hb.application.user.implementation;

import ar.lamansys.cart.hb.application.user.exceptions.UserDoesNotExistException;
import ar.lamansys.cart.hb.application.user.interfaces.FindUserService;
import ar.lamansys.cart.hb.application.user.port.UserPort;
import ar.lamansys.cart.hc.domain.user.UserBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindUserServiceImpl implements FindUserService {

    private UserPort userPort;

    @Override
    public UserBO run(Integer id) throws UserDoesNotExistException {
        return userPort.findById(id)
                .orElseThrow(() -> new UserDoesNotExistException(id));
    }
}
